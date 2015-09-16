/*************************************************************************
    > File Name: 14_LongestCommonPrefix.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/longest-common-prefix/
    > Created Time: 三  9/16 16:45:46 2015
    思路：字符串数组中的最长公共子串，如果字符串数组中有长度为0的值，直接返回0， 否则 对每个值进行比较，比较时 长度选择存储结果集和当前集
    两者长度小的那个（最长公共子串肯定选校的） 判断处理即可
 ************************************************************************/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        
        if (strs.length == 0) {
            return "";
        }
        
        result = strs[0];
        
        for (int i = 1; i < strs.length; i ++) {
            if (result.length() == 0 || strs[i].length() == 0) {
                return "";
            }
            
            int minLen = result.length() < strs[i].length() ? result.length() : strs[i].length();
            int j;
            
            for (j = 0; j < minLen; j ++) {
                if (result.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            
            result = result.substring(0, j);
        }
        
        return result;
    }
}