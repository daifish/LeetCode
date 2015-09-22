/*************************************************************************
    > File Name: 037_SudukuSolver.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/sudoku-solver/
    > Created Time: 二  9/22 11:23:31 2015
 ************************************************************************/
/*
    回溯法，向每个格子填充，填充后进行合法性验证，如果通过，继续下一个格子，不通过回溯
*/
public class Solution {
    public void solveSudoku(char[][] board) {
        if (board==null||board.length==0)
            return;
            
        fill(board);
    }
    //遍历2维数组
    public boolean fill (char[][] board) {
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == '.') {
                    //添加1-9，依次尝试，成功则添加，不行则
                    for (char num = '1'; num <= '9'; num ++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            
                            if (fill(board)) {
                                return true;
                            }
                        
                            else {
                                //回溯
                                board[i][j] = '.';
                            }
                        }
                        
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isValid(char[][] board, int i, int j, char curc) {
        for (int column = 0; column < 9; column ++) {
            if (board[i][column] == curc) {
                return false;
            }
        }
        
        for (int row = 0; row < 9; row ++) {
            if (board[row][j] == curc) {
                return false;
            }
        }
        
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row ++) {
            for (int column = j / 3 * 3; column < j / 3 * 3 + 3; column ++) {
                if (board[row][column] == curc) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
