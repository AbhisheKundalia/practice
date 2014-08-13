/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;

/**
 *
 * @author admin
 */
public class surroundedRegions {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
  
        for(int i = 0; i < col; i++){
            if(board[0][i] == 'O'){
                solveFromOnePoint(board, 0, i);
            } 
            if(board[row-1][i] == 'O'){
               solveFromOnePoint(board, row-1, i);  
            } 
        }
        
         for(int i = 1; i < row - 1; i++){
            if(board[i][col-1] == 'O'){
                solveFromOnePoint(board, i, col-1);
            } 
            if(board[i][0] == 'O'){
                solveFromOnePoint(board, i, 0);
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
    }
    
    public void solveFromOnePoint(char[][] board, int x, int y){
           int row = board.length, col = board[0].length;
           board[x][y] = 'Y';
           
           if(x+1 < row && board[x+1][y] == 'O'){
               solveFromOnePoint(board, x+1, y);
           }
           
           if(x-1 >= 0 && board[x-1][y] == 'O'){
               solveFromOnePoint(board, x-1, y);
           }
           
           if(y+1 < col && board[x][y+1] == 'O'){
               solveFromOnePoint(board, x, y+1);
           }
           
           if(y-1 >= 0 && board[x][y-1] == 'O'){
               solveFromOnePoint(board, x, y-1);
           }
    }
    
    //recursion时，我们保存了X, Y的坐标，所以我们也可以用Q来存储这2个值
    
     public void solve2(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        Queue<Integer> index = new LinkedList<Integer>();
        Queue<Integer> indexy = new LinkedList<Integer>();
        
        for(int i = 0; i < col; i++){
            if(board[0][i] == 'O'){
                index.add(0);
                indexy.add(i);
            } 
            if(board[row-1][i] == 'O'){
               index.add(row-1);
               indexy.add(i);
            } 
        }
        
         for(int i = 1; i < row - 1; i++){
            if(board[i][col-1] == 'O'){
                index.add(i);
                indexy.add(col-1);
            } 
            if(board[i][0] == 'O'){
                index.add(i);
                indexy.add(0);
            }
        }
        
         
         while(!index.isEmpty()){
             int x = index.poll();
             int y = indexy.poll();
             board[x][y] = 'Y';
             
             if(x>=1 && board[x-1][y] == 'O'){
                 index.add(x-1);
                 indexy.add(y);
             }
             
             if(x+1<row && board[x+1][y] == 'O'){
                 index.add(x+1);
                 indexy.add(y);
             }
             
             if(y>=1 && board[x][y-1] == 'O'){
                 index.add(x);
                 indexy.add(y-1);
             }
             if(y + 1<col && board[x][y+1] == 'O'){
                 index.add(x);
                 indexy.add(y+1);
             }    
         }
         
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
    }
}
