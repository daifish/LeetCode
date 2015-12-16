/*************************************************************************
    > File Name: 7_ReverseInteger.java
    > Author: daiyu
	> url:https://leetcode.com/problems/reverse-integer/
    > Created Time: 三  9/16 10:31:13 2015
    注意溢出处理，此处对操作的result用long类型，防止溢出，最大最小值定义如integer.max_value
    如果溢出返回0，shit oj，移位操作即％ long－> int 可以现将long转化为字符串，再用integer.parseint
 ************************************************************************/
public class Solution {
    public int reverse(int x) {
        long result = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        if (x == 0) 
            return x;
        
        while (x != 0) {
            int tmp = x % 10;
            result = result * 10 + tmp;
            
            if (result > max || result < min) {
                return 0;
            }
                                    
            x = x / 10;
        }
        
        return Integer.parseInt(String.valueOf(result));        
    }
}
//6ms
/*
转换成字符串处理 对于最后的越界用try catch捕获处理
*/
public class Solution {
    public int reverse(int x) {
        String result = "";
        int res = 0;
        
        String tmp = String.valueOf(Math.abs(x));
        
        for (int i = tmp.length() - 1; i >= 0 ; i --) {
            result += tmp.charAt(i);
        }
        
        try {
            res = Integer.parseInt(result);
            if (x > 0) {
                return res;
            } else {
                return -res;
            }
        } catch(Exception e) {
            return 0;
        }
        
        
    }
}
