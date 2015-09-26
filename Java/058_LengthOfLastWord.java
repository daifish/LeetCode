/*************************************************************************
    > File Name: 058_LengthOfLastWord.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/length-of-last-word/
    > Created Time: 六  9/26 20:58:35 2015
 ************************************************************************/
public class Solution {
    public int lengthOfLastWord(String s) {
        String []ss = s.trim().split(" ");
        int length = ss.length;
        //eg:s = "" or s = "      "  care these two
        if (s.length() == 0 || s.trim().equals("")) {
            return 0;
        }
        
        return ss[length - 1].length();
    }
}
