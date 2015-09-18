/*************************************************************************
    > File Name: 9_PalindromeNumber.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/palindrome-number/
    > Created Time: 三  9/16 11:17:05 2015
    思路：特殊处理，负数时，返回false，0或者小于10时返回true， 大于10时，转化为字符串，折半处理，判断是否相等
    注意是i 和 length - 1 - i对比
 ************************************************************************/
public class Solution {
    public boolean isPalindrome(int x) {
        boolean result = true;
        
        if (x < 0)
            return false;
            
        else if (x < 10)
            return true;
            
        else {
            String s = String.valueOf(x);
            int length = s.length();
            
            for (int i = 0; i < length / 2; i ++) {
                if (s.charAt(i) == s.charAt(length - i - 1)) {
                    continue;
                } else {
                    return false;
                }
            }
            
        }
        
        return result;
    }
}
