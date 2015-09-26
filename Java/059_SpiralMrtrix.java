/*************************************************************************
    > File Name: 059_SpiralMrtrix.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/spiral-matrix-ii/
    > Created Time: 六  9/26 21:21:43 2015
 ************************************************************************/
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int begin = 0;
        int end = n - 1;
        int curNum = 1;
        
        
        while (begin < end) {
            for (int i = begin; i < end; i ++) {
                matrix[begin][i] = curNum ;
                curNum ++;
            }
            
            for (int i = begin; i < end; i ++) {
                matrix[i][end] = curNum;
                curNum ++;
            }
            
            for (int i = end; i > begin; i --) {
                matrix[end][i] = curNum;
                curNum ++;
            }
            
            for (int i = end; i > begin; i --) {
                matrix[i][begin] = curNum;
                curNum ++;
            }
            
            begin ++;
            end --;
        }
        
        if (begin == end) {
            matrix[begin][end] = curNum;
        }
        
        return matrix;
        
    }
}
