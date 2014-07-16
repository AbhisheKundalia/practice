/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class minimumSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if(row < 1) return 0;
        
        int col = grid[0].length;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i > 0 && j > 0){
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }else if(i > 0){
                    grid[i][j] += grid[i-1][j];
                }else if(j > 0){
                    grid[i][j] += grid[i][j-1];
                }
            }
        }
        
        return grid[row-1][col-1];
    }
}
