/*************************************************************************
    > File Name: 150_EvaluateReversePolishNotation.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 四 10/29 14:17:09 2015
 ************************************************************************/
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        int result = 0;
        String operate = "+-*/";
        
        for (String s : tokens) {
            if (!operate.contains(s)) {
                stack.push(s);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                
                switch(s) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }
        
        result = Integer.valueOf(stack.pop());
        
        return result;
        
    }
}
