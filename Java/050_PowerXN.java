/*************************************************************************
    > File Name: 050_PowerXN.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/powx-n/
    > Created Time: 三  9/23 21:58:43 2015
 ************************************************************************/
/*
pow(x,n)就是求x的n次方。x的N次方可以看做：x^n = x^(n/2)*x^(n/2)*x^(n%2)。所以利用递归求解，当n==1的时候，x^n=x。

当然n是可以小于0的，2^(-3) = 1/(2^3)。按照上面那个规律就可以解决了。
*/
public class Solution {
   public double power(double x, int n) {
        if (n == 0)
            return 1;
 
        double v = power(x, n / 2);
 
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }
 
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -n);
        } else {
            return power(x, n);
        }
    }
}
