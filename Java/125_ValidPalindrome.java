/*************************************************************************
    > File Name: 125_ValidPalindrome.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/valid-palindrome/
    > Created Time: 一 10/26 14:03:33 2015
 ************************************************************************/
public class Solution {
    public boolean isPalindrome(String s) {
        //任何不属于a-zA-Z0-9的字符都会被""代替，讲道理的话主要是替代中间的空格
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int len = s.length();
        int index = 0;
        if (len < 2) {
            return true;
        }
        
        Stack<Character> stack = new Stack<Character>();
        while (index < len / 2) {
            stack.push(s.charAt(index));
            index ++;
        }
        
        if (len % 2 == 1) {
            index ++;
        }
        
        while (index < len) {
            if (stack.empty()) {
                return false;
            }
            
            char temp = stack.pop();
            if (s.charAt(index) != temp) {
                return false;
            } else {
                index ++;
            }
        }
        
        return true;
    }
}
