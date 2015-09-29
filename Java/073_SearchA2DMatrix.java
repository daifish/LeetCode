/*
思路1：二分法确定target可能在第几行出现。再用二分法在该行确定target可能出现的位置。时间复杂度O(logn+logm)
思路2：从右上角元素开始遍历，每次遍历中若与target相等则返回true；若小于则行向下移动；若大于则列向左移动。时间复杂度m+n
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length;
        
        if (left != right) {
            while (left <= right) {
                int middle = left + (right - left) / 2;
                
                if (matrix[middle][0] < target) {
                    left = middle + 1;
                } else if (matrix[middle][0] > target) {
                    right = middle - 1;
                } else {
                    return true;
                }
            }
        }
        
        if (right == -1) {
            return false;
        }
        
        else {
            int row = right;
            left = 0;
            right = matrix[0].length - 1;
            
            while (left <= right) {
                int middle = left + (right - left) / 2;
                
                if (matrix[middle][0] < target) {
                    left = middle + 1;
                } else if (matrix[middle][0] > target) {
                    right = middle - 1;
                } else {
                    return true;
                }
            }
            
            return false;
        }
        // int i = matrix.length - 1;
        // int j = 0;
        // int row = matrix.length;
        // int col = matrix[0].length;
        
        // while (i >= 0 && j < col) {
        //     if (matrix[i][j] == target) {
        //         return true;
        //     }
            
        //     else if (matrix[i][j] < target) {
        //         j ++;
        //     } 
            
        //     else {
        //         i --;
        //     }
        // }
        
        // return false;
    }
}
