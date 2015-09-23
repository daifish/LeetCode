/*************************************************************************
    > File Name: 048_RotateImage.java
    > Author: daiyu
    > Url: https://leetcode.com/problems/rotate-image/
    > Created Time: 三  9/23 20:46:10 2015
 ************************************************************************/
/*
    n = 1时 不动
    n = 2时 分析－> a[i][j] = a[n - j - 1][i]
    所以最简单的情况就是新建一个数组[n][n] 旋转后赋值给新数组就行
    在原地处理的话，以n＝3为例，设计下列4个旋转的数字
    需判断什么时候旋转：i<n/2; i <= j <= n - i - 1 
*/
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int limit = (n - 1) / 2;
    
        for (int i = 0; i <= limit; i ++) {
            for (int j = i; j < n - i - 1; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
