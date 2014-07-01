/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author admin
 */
public class sudoku {
    public void solveSudoku(char[][] board) {
        
    }
   
    public boolean validSudoku(char[][] board) {
        int[][] record = new int [3][9];
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    int temp = 1<<num;
                    int index = (i/3) * 3 + j/3;
                    
                    if(temp == (record[0][i] & temp) || (record[1][j] & temp) == temp || (record[2][index] & temp) == temp){
                        return false;
                    }
                    
                    record[0][i] += temp;
                    record[1][j] += temp;
                    record[2][index] += temp;
                }
            }
        }
        
        return true;
    }   
}
