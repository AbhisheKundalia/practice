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
public class spiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        List<Integer> res = new ArrayList<Integer>();
        
        if(row < 1) return res;
        int col = matrix[0].length;
        
        for(int i = 0; 2*i <= col -1 && 2*i <= row -1; i++){
            for(int j = i; j <= col - 1 - i; j++){
                res.add(matrix[i][j]);
            }
            
            for(int j = i+1; j <= row - 1 - i; j++){
                res.add(matrix[j][col-i-1]);
            }
            
            for(int j = col-2-i; j >= i && row-i-1 > i ; j--){
                res.add(matrix[row-1-i][j]);
            }
            
             for(int j = row-2-i; j > i && col -1 - i >  i; j--){
                res.add(matrix[j][i]);
            }           
        }
        
        return res;
        
    }
}
