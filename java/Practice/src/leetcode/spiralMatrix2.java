/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class spiralMatrix2 {
     public int[][] generateMatrix(int n) {
        
       int[][] matrix = new int[n][n];
        
       if(n < 1) return matrix;
       int count = 1;
        
        for(int i = 0; 2*i <= n - 1; i++){
            for(int j = i; j <= n - 1 - i; j++){
                matrix[i][j] = count;
                count++;
            }
            
            for(int j = i+1; j <= n - 1 - i; j++){
                matrix[j][n-i-1] = count;
                count++;
            }
            
            for(int j = n-2-i; j >= i && n-1 > 2*i ; j--){
                matrix[n-1-i][j] = count;
                count++;
            }
            
             for(int j = n-2-i; j > i && n -1 > 2*i; j--){
                matrix[j][i] = count;
                count++;
            }           
        }
        
        return matrix; 
    }
}
