/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class sudoku {
    public void solveSudoku(char[][] board) {
         int[][] record = new int [3][9];
         
         for(int i = 0; i < 9; i++){
             for(int j = 0; j < 9; j++){
                 if( board[i][j] > '0' && board[i][j] <= '9'){
                     int n = board[i][j] - '1';
                     int tmp = 1 << n;
                     int index = (i/3)*3+ j/3;
                     
                     record[0][i] += tmp;
                     record[1][j] += tmp;
                     record[2][index] += tmp;       
                 }
             }
         }
         
         solveSudoku0(board, record);
    }
    
    public boolean solveSudoku0(char[][] board, int[][] record){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(int t = 1; t < 10; t++){
                        int tmp = 1 << (t-1);
                        int index = (i/3) * 3 + j/3;
                        
                         if(tmp == (record[0][i] & tmp) || (record[1][j] & tmp) == tmp || (record[2][index] & tmp) == tmp){
                          continue;
                        }else{
                             record[0][i] += tmp;
                             record[1][j] += tmp;
                             record[2][index] += tmp;
                             
                             board[i][j] = (char) (t + '0');
                             boolean correct = solveSudoku0(board, record);
                             
                             if(correct){
                                 return correct;
                             }else{
                                 board[i][j] = '.';
                                 record[0][i] ^= tmp;
                                 record[1][j] ^= tmp;
                                 record[2][index] ^= tmp;
                             }
                         }     
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
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
