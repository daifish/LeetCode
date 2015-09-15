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
		}
		
		for (int i = 0 ; i <= length - 2; i ++){
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = 1;
				longestStr = s.substring(i, i + 2);
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
