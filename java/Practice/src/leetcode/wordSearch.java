/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class wordSearch {
    public boolean exist(char[][] board, String word) {
        if(word.length() < 1) return true;
        
        int row = board.length;
        if(row < 1) return false;
        
        int col = board[0].length;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                boolean[][] visited = new boolean[row][col];
                if(board[i][j] == word.charAt(0) && search(board, i, j, visited, word, 0)){
                   return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean search(char[][] board, int x, int y, boolean[][] visited, String word, int pos){    

        if(board[x][y] != word.charAt(pos)) return false;
        
        pos++;
        
        if(pos == word.length()) return true;
         visited[x][y] = true;
         
        if(x-1>= 0 && !visited[x-1][y] && board[x-1][y] == word.charAt(pos)){         
            boolean exist = search(board, x-1, y, visited, word, pos);
            if(exist) return true;
        }  
        
        if(y-1>= 0 && !visited[x][y-1] && board[x][y-1] == word.charAt(pos)){         
            boolean exist = search(board, x, y-1, visited, word, pos);
            if(exist) return true;
        }  
        
        if(x+1 < board.length && !visited[x+1][y] && board[x+1][y] == word.charAt(pos)){         
            boolean exist = search(board, x+1, y, visited, word, pos);
            if(exist) return true;
        }  
        
        if(y+1 < board[0].length && !visited[x][y+1] && board[x][y+1] == word.charAt(pos)){         
            boolean exist = search(board, x, y+1, visited, word, pos);
            if(exist) return true;
        }
        
        return false;
    }
}
