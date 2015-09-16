/*************************************************************************
    > File Name: 12_IntToRoma.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/integer-to-roman/
    > Created Time: 三  9/16 15:33:54 2015
    思路：创建两个辅助数组，对给定数字，如果大于数字数组中的值则减去当前数，并在结果集中添加对应位置字母
 ************************************************************************/
public class Solution {
    public String intToRoman(int number) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder result = new StringBuilder();
        
        if (number < 1) {
            return "";
        }
        
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                result.append(numerals[i]);
            }
        }
        return result.toString();
    }
}
