/*************************************************************************
    > File Name: 120_Triangle.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/triangle/
    > Created Time: 一 10/26 10:26:09 2015
 ************************************************************************/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        
        int[] dp = new int[triangle.size()];
        //初始化最底的一行
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i ++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        //从下往上遍历,递推公式是： dp[i][j] = dp[i+1][j] + dp[i+1][j+1] ，当前这个点的最小值，由他下面那一行临近的2个点的最小值与当前点的值相加得到。
        for (int i = triangle.size() - 2; i >= 0; i --) {
            for (int j = 0; j < triangle.get(i).size(); j ++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        
        return dp[0];
    }
}
