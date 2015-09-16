/*************************************************************************
    > File Name: 6_ZigZagConversion.java
    > Author: daiyu
    > Url: https://leetcode.com/problems/zigzag-conversion/
    > Created Time: 三  9/16 09:11:24 2015
    本题第0行和n-1行每两个数都间隔2(n-1)，而第1行到n-2行之间间隔为2(n-1-i)，2i，其中i代表该行行号
    先处理特殊情况，再依次处理即可
 ************************************************************************/

public class Solution {
    public String convert(String s, int numRows) {
        StringBuffer result = new StringBuffer();
        int length = s.length();
        
        if (numRows <= 1 || length < numRows || s == null) 
            return s;
        //first line
        for (int i = 0; i < length; i += 2 * (numRows - 1)) {
            result.append(s.charAt(i));
        }
        
        //seconde to numRows - 1
        for (int i = 1; i < numRows - 1; i ++) {
            for (int j = i; j < length; j += 2 * (numRows - 1)) {
                result.append(s.charAt(j));
                if (j +  2 * (numRows - 1 - i) < length) {
                    result.append(s.charAt(j + 2 * (numRows - 1 - i)));
                }
            }
        }
        
        
        //last line
        for (int i = numRows - 1; i < length; i += 2 * (numRows - 1)) {
            result.append(s.charAt(i));
        }
        
        return result.toString();
    }
}