/*************************************************************************
    > File Name: 060_PermutationSequence.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/permutation-sequence/
    > Created Time: 日  9/27 12:45:43 2015

    有待解决 不太理解
 ************************************************************************/
public class Solution {
    public String getPermutation(int n, int k) {
        boolean[] output = new boolean[n];
        StringBuilder buf = new StringBuilder("");
        
        int[] res = new int[n];
        res[0] = 1;
        //计算n!
        for (int i = 1; i < n; i ++) {
            res[i] = res[i - 1] * i;
        }
        
        for (int i = n - 1; i >= 0; i --) {
            int s = 1;
            
            while (k > res[i]) {//k-=res[i] 表示 少了1位的情况下的阶乘数
                //如例子中，k=5 n=3时，k－2！－2！从而到第三组3开头的阶乘组
                s ++;
                k = k - res[i];
            }
            
            for (int j = 0; j < n; j ++) {
                if (j + 1 <= s && output[j]) {//该位的值已经输出过了，且
                    s ++;
                }
            }
            
            output[s - 1] = true;//该值已经输出
            buf.append(Integer.toString(s));
        }
        
        return buf.toString();
    }
}
