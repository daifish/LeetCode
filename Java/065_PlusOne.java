/*************************************************************************
    > File Name: 065_PlusOne.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/plus-one/
    > Created Time: 日  9/27 14:43:37 2015
 ************************************************************************/
public class Solution {
    public int[] plusOne(int[] digits) {
        int flag = 1;
        int i = 0;
        
        for (i = digits.length - 1; i >= 0; i --) {
            digits[i] = digits[i] + flag;
            if (digits[i] > 9) {
                flag = 1;//进位
                digits[i] = 0;
            } else {
                return digits;
            }
        }
        //最后产生进位
        if (i == -1 && flag == 1) {
            int []newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (i = 1; i <= digits.length; i ++) {
                newDigits[i] = digits[i - 1];
            }
            
            return newDigits;
        } else {
            return digits;
        }
    }
}
