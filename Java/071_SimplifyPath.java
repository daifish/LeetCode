/*
1.判断字符串相等与否要用.equals()，因为是引用类型。

2.要注意split函数是可以split出空字符的，例如：//b/ 会被split结果为["","b"]。

3.最后使用StringBuilder进行拼接，由于String在每次对字符串修改时候均会生成一个新的String，效率较低，一般会采用StringBuilder或者StringBuffer来进行字符串修改的操作，StringBuilder是StringBuffer的简易替换，是非线程安全的，而StringBuffer是线程安全的。
*/
public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        
        Stack<String> stack = new Stack<String>();
        Stack<String> temp = new Stack<String>();
        String[] array = path.split("/");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < array.length; i ++) {
            if (array[i].equals(".") || array[i].length() == 0) continue;
            
            else if (!array[i].equals("..")) stack.push(array[i]);
            
            else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        
        while (!stack.isEmpty()) 
            temp.push(stack.pop());
            
        while (!temp.isEmpty())
            result.append("/" + temp.pop());
            
        if (result.length() == 0) 
            result.append("/");
        
        return result.toString();
    }
}
