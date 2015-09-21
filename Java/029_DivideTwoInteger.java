/*************************************************************************
    > File Name: 029_DivideTwoInteger.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/divide-two-integers/
    > Created Time: 一  9/21 09:14:38 2015
    实现除法，用移位操作实现
 ************************************************************************/
/*
divisor每次翻一番，当翻到比dividend大的时候，记录增长的倍数。更新dividend，再从divisor开始增长。

例如12 / 1，1->2->4->8->16 （16 > 12）则回到将dividend更新为12- 8= 4。然后divisior再从1开始增长 1 ->2->4结束。
*/
public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0 || divisor == 0) return 0;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        if(absDividend < absDivisor) return 0;
        int res = 0;
        int max = Integer.MAX_VALUE;
        
        while(absDividend >= absDivisor){
            long count = 1;
            long tem = absDivisor;
            
            while(tem < absDividend){
                // tem * 2 直到当前值大于除数
                tem <<= 1;
                count <<= 1;
            }
            if(tem != absDivisor) {
                // >> 为除法 << 为乘法
                tem >>= 1;
                count >>= 1;
            }
            res += count;
            absDividend -= tem;
        }
        
        if (Math.abs((long) res) >= max) {
            if ((dividend < 0 ^ divisor < 0 ? (-1) : 1) == 1 ) {
                return max;
            } else {
                return -Integer.MIN_VALUE;
            }
        } 
        //这个异或用很不错
        return res * (dividend < 0 ^ divisor < 0 ? (-1) : 1);    
    }
}
