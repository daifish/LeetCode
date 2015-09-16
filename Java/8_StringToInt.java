/*************************************************************************
    > File Name: 8_StringToInt.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/string-to-integer-atoi/
    > Created Time: 三  9/16 10:54:30 2015
 ************************************************************************/
public class Solution {
    public int myAtoi(String str) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int begin = 0;
        str = str.trim();//firstly 处理空格
        int length = str.length();
        long result = 0;
        boolean flag = false;//default the number is > 0 
        
        if (length < 1) 
            return 0;
        
        if (str.charAt(begin) == '-' || str.charAt(begin) == '+') {
            //判断该数为正or负
            if (str.charAt(begin) == '-')
                flag = true;
            begin++;
        }
        
        for (int i = begin; i < length; i ++) {
            char c = str.charAt(i);
            //如果为字符 则跳出
            if (c < '0' || c > '9') 
                break;
            //数字则上位*10 ＋ 该位的值
            result = result * 10 + (c - '0');
            //正数溢出 返回max
            if (!flag && result > max)
                return max;
            //负数溢出 返回min
            if (flag && -result < min)
                return min;
        }
        //负数处理
        if (flag)
            result = -result;
        
        return (int) result;
    }
}
