/*
利用第一行和第一列记录，判断该行或者该列是否需要变成0， 如果matrix[i][j]为0，那么matrix[i][0]、matrix[0][j]都记为0
根据第一行第一列的值将该行该列都置0，最后由两个标记值 判断是否将第1行第1列 置0
*/
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        
        for (int i = 0; i < matrix.length; i ++) {
            if (matrix[i][0] == 0) {
                firstColumnZero = true;
                break;
            }
        }
        
        for (int i = 0; i < matrix[0].length; i ++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        for (int i = 1; i < matrix.length; i ++) {
            for (int j = 1; j < matrix[0].length; j ++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
         for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                   matrix[i][j] = 0;
                }
            }
        }
 
        //set first column and row
        if(firstColumnZero){
            for(int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
        }
 
        if(firstRowZero){
            for(int i=0; i<matrix[0].length; i++)
                matrix[0][i] = 0;
        }
    }
}
