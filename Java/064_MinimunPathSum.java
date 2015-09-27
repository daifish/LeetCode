/*************************************************************************
    > File Name: 064_MinimunPathSum.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/minimum-path-sum/
    > Created Time: 日  9/27 14:12:39 2015
 ************************************************************************/
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        if (m == 0 || n == 0) return 0;
        
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + grid[i][0];
                } else if (i == 0) {
                    dp[0][j] = dp[0][j - 1] + grid[0][j];
                } else {
                    int min = dp[i - 1][j] - dp[i][j - 1] > 0 ? dp[i][j - 1] : dp[i - 1][j];
                    dp[i][j] = min + grid[i][j];
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
