/*************************************************************************
    > File Name: 062_UniquePaths.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/unique-paths/
    > Created Time: 日  9/27 13:42:49 2015
 ************************************************************************/
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) return 0;
        if (m == 1 && n == 1) return 1;
        
        int [][]dp = new int[m][n];
        
        for (int i = 0; i < m; i ++) {
            dp[i][0] = 1;
        }
        
        for (int i = 0; i < n; i ++) {
            dp[0][i] = 1;
        }
        
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        } 
        
        return dp[m - 1][n - 1];
    }
    // public int uniquePaths(int m, int n) {
    //     return helper(0, 0, m, n);
    // }
    
    // public int helper(int i, int j, int m, int n) {
    //     if (i == m - 1 && j == n - 1) {
    //         return 1;
    //     }
        
    //     if (i < m - 1 && j < n - 1) {
    //         return helper(i + 1, j, m, n) + helper(i, j + 1, m, n);
    //     }
        
    //     if (i < m - 1) {
    //         return helper(i + 1, j, m, n);
    //     }
        
    //     if (j < n - 1) {
    //         return helper(i, j + 1, m, n);
    //     }
        
    //     return 0;
    // }
}
