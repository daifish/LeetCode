/*************************************************************************
    > File Name: 079_WordSearch.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/word-search/
    > Created Time: 一 10/12 15:13:35 2015
 ************************************************************************/
public class Solution {
    public static boolean exist(char[][] board, String word) {  
        // 对每一个节点进行深搜  
        for(int i=0; i<board.length; i++){  
            for(int j=0; j<board[0].length; j++){  
                if(dfs(board, word, 0, i, j)){  
                    return true;  
                }  
            }  
        }  
        return false;  
    }  
       
    // dfs搜索  
    public static boolean dfs(char[][] board, String word, int index, int x, int y){  
        if(index == word.length()-1 && word.charAt(index)==board[x][y]){  
            return true;  
        }  
           
        if(word.charAt(index) != board[x][y]){  
            return false;  
        }  
           
        char tmp = board[x][y];     // 保存原始值  
        board[x][y] = '.';  // 判断是否访问过
        boolean b1 = false, b2 = false, b3 = false, b4 = false;  
        if(x-1>=0 && board[x-1][y] != '.'){  
            b1 = dfs(board, word, index+1, x-1, y);  
        }  
        if(!b1 && y-1>=0 && board[x][y-1] != '.'){  
            b2 = dfs(board, word, index+1, x, y-1);  
        }  
        if(!b1 && !b2 && x+1<board.length && board[x+1][y] != '.'){  
            b3 = dfs(board, word, index+1, x+1, y);  
        }  
        if(!b1 && !b2 && !b3 && y+1<board[0].length && board[x][y+1] != '.'){  
            b4 = dfs(board, word, index+1, x, y+1);  
        }  
           
        board[x][y] = tmp;          // 还原原始值  
        return b1 || b2 || b3 || b4;  
    }  
}
