/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row < 0) return false;
        
        int col = matrix[0].length;
        int start = 0;
        int end = row*col -1;
        
        while(start<=end){
            int middle = (start+end)/2;
            if(matrix[middle/col][middle%col] == target) return true;
            if(matrix[middle/col][middle%col] > target){
                end = middle - 1;   
            }else{
                start = middle + 1;
            }
        }
        
        return false;
        
    }
}
