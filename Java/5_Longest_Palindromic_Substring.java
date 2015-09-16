/*
遍历一遍字符串，对每位字符串进行同时向左向右的探测，判断是否符合回文规则，注意考虑奇偶数两种情况
author:daiyu
time:2015-9-16
url:https://leetcode.com/problems/longest-palindromic-substring/
*/
public class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
			return null;
		}
		if (s.length() == 1) {
			return s;
		}
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
		// get longest palindrome with center of i
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}

			// get longest palindrome with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
			return longest;
	}

	// Given a center, either one letter or two letter,
	// Find longest palindrome
    public static String helper(String s, int begin, int end) {
    	while (begin >= 0 && end <= s.length() - 1
    				&& s.charAt(begin) == s.charAt(end)) {
    		begin--;
    		end++;
    	}
    	String subS = s.substring(begin + 1, end);
    	return subS;
    }
}
/*
思路：首先处理单字符的时候 即table[i][i]置为1，再处理步长为2的时候，即table[i][i + 1]，如果两者相等，则置为1
同时取最长字符串，接下来则进行循环（步长从3到字符串的长度），工作指针i从0开始到s.length() - 步长， 右侧工作指针
一直为i ＋ step - 1, 判断i j 处的值是否相等，如果相等，则table[i][j]= table[i + 1][j - 1](即里层的值) 如果当前的table[i][j]
值为1，且此时的步长大于给定的maxlen,更新longeststr返回值和maxlen，如果i j处值不等则table[i][j]置0

*/
public class Solution2{
	public String longestPalindromic(String s) {
		int maxLen = 0;
		int length = s.length();
		int table[][] = new int[length][length];
		String longestStr = null;
		
		if (length == 0) 
			return null;
		
		if (length == 1)
			return s;
			
		for (int i = 0; i <= length; i++) {
			table[i][i] = 1;
			maxLen = 1;
		}
		
		for (int i = 0 ; i <= length - 2; i ++){
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = 1;
				longestStr = s.substring(i, i + 2);
				maxLen = 2;
			}
		}
		
		for (int step = 3; step <= length; step++) {
			for (int i = 0; i <= length - step; i++) {
				int j = i + step - 1;
				if (s.charAt(i) == s.charAt(j)) {
					table[i][j] = table[i + 1][j - 1];
					if(table[i][j] == 1 && step > maxLen) {
						longestStr = s.substring(i, j + 1);
						maxLen = step;
					}
				} else {
					table[i][j] = 0;
				}
			}
		}
		
		return longestStr;
		
	}
}
