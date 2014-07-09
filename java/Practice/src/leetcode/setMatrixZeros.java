/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class setMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if(row < 1) return;
        
        int col = matrix[0].length;
        
        boolean[] rowchange = new boolean[row];
        boolean[] colchange = new boolean[col];
        
        for(int i = 0 ; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 0){
                    if(!rowchange[i]){
                        rowchange[i] = true;
                        
                        int t = j-1;
                        while(t >= 0){
                            matrix[i][t] = 0;
                            t--;
                        }
                    }
                    
                    if(!colchange[j]){
                        colchange[j] = true;
                        
                        int k = i-1;
                        while(k >= 0){
                            matrix[k][j] = 0;
                            k--;
                        }
                        
                    }
                }else if(rowchange[i] || colchange[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
