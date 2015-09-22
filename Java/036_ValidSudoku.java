/*************************************************************************
    > File Name: 036_ValidSudoku.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/valid-sudoku/
    > Created Time: 二  9/22 10:17:08 2015
 ************************************************************************/
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //核心思想：hashset唯一性验证
        HashSet<Character> set = new HashSet<Character>();
        Boolean result = true;
        //each row
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.') {
                    continue;
                }   
                
                if (set.contains(board[i][j])) {
                    return false;
                }
                
                set.add(board[i][j]);
            }
            
            set.clear();
        }
        //each column
        for (int j = 0; j < 9; j ++) {
            for (int i = 0; i < 9; i ++) {
                if (board[i][j] == '.') {
                    continue;
                }   
                
                if (set.contains(board[i][j])) {
                    return false;
                }
                
                set.add(board[i][j]);
            }
            
            set.clear();
        }
        
        //each 9-grid
        for (int k = 0; k < 9; k ++) {
            for (int i = k / 3 * 3; i < k / 3 * 3 + 3; i ++) {
                for (int j = (k % 3) * 3; j < (k % 3) * 3 + 3; j ++) {
                    if (board[i][j] == '.') {
                        continue;
                    }        
                    
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    
                    set.add(board[i][j]);
                }
            }
            
            set.clear();
        }
        
        
        return result;
    }
}
