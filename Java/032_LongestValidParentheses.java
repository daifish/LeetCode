/*************************************************************************
    > File Name: 032_LongestValidParentheses.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/longest-valid-parentheses/
    > Created Time: 二  9/22 08:51:13 2015
 ************************************************************************/
public class Solution {
    public int longestValidParentheses(String s) {
        Boolean []array = new Boolean[s.length()];
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int cur = 0;
        
        for (int i = 0; i < s.length(); i ++) {
            array[i] = false;
        }
        
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')' && !stack.empty()) {
                array[i] = true;
                array[stack.peek()] = true;
                stack.pop();
            }
        }
        
        for (int i = 0; i < s.length(); i ++) {
            if (array[i]) {
                cur ++;
            } else {
                cur = 0;
            }
            
            max = max > cur ? max : cur;
        }
        
        return max;
    }
}
