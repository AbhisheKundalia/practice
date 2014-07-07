/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class rotateImage {
      public void rotate(int[][] matrix) {
        int row = matrix.length;
          
        for(int i = 0; i < row; i++){
            for(int j = 0; j < i; j++){
               int temp = matrix[i][j];
               matrix[i][j] = matrix[j][i];
               matrix[j][i] = temp;
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j <= row/2; j++){
               int temp = matrix[i][j];
               matrix[i][j] = matrix[i][row - 1 - j];
               matrix[i][row - 1 - j] = temp;
            }
        }
        
    }
}
