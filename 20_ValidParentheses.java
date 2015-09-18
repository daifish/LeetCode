/*************************************************************************
    > File Name: 20_ValidParentheses.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/valid-parentheses/
    > Created Time: 五  9/18 09:02:26 2015
 ************************************************************************/
public class Solution {
    /*
        利用hashmap，如果是({[, 放入栈中，如果是}]), 否则返回false，
        判断栈顶是否有元素
        如果有，判断栈顶元素和当前元素是否配对， 如果配对出战并继续循环，不配对 返回false
        hashmap常用操作，keySet()->key值集合，values()->value值集合
        stack常用操作，peek()->查看栈顶元素 并不移除
    */
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i ++) {
            char curr = s.charAt(i);
            
            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } 
            
            else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                }
                
                else {
                    return false;
                }
            }
            
            else {
                return false;
            }
        }
        
        return stack.empty();
    }
}
