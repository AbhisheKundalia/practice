/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 * 
 * 
 * 用递归。
 * 最开始一直没有通过，是因为每次回溯的时候，我都会开辟一个新的二位 VISITED的数组。这样很浪费内存
 * 
 * 
 */
public class wordSearch {
    public boolean exist(char[][] board, String word) {
        if(word.length() < 1) return true;
        
        int row = board.length;
        if(row < 1) return false;
        
        int col = board[0].length;
        
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                
                if(search(board, i, j, visited, word, 0)){
                   return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean search(char[][] board, int x, int y, boolean[][] visited, String word, int pos){    

        if(board[x][y] != word.charAt(pos) || visited[x][y]) return false;
        
        visited[x][y] = true;
        pos++;
        
        if(pos == word.length()) return true;
            
        if(x-1>= 0 && search(board, x-1, y, visited, word, pos)){         
            return true;
        }  
        
        if(y-1>= 0 && search(board, x, y-1, visited, word, pos)){         
             return true;
        }  
        
        if(x+1 < board.length && search(board, x+1, y, visited, word, pos)){         
            return true;
        }  
        
        if(y+1 < board[0].length && search(board, x, y+1, visited, word, pos)){         
           return true;
        }
        
        visited[x][y] = false;
        
        return false;
    }
}
