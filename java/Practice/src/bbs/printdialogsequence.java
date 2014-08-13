/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbs;

import java.util.*;
/**
 *
 * @author admin
 * 
 * 
 * Problem : 
Given a 2D matrix, print all elements of the given matrix in diagonal order.
For example, consider the following 5 X 4 input matrix.
    1     2     3     4
    5     6     7     8
    9    10    11    12
   13    14    15    16
   17    18    19    20

Diagonal printing of the above matrix is
    1
    5     2
    9     6     3
   13    10     7     4
   17    14    11     8
   18    15    12
   19    16
   20
 */
public class printdialogsequence {
    public void printDialogsequence(int[][] array){
        int row = array.length;
        int col = array[0].length;
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < row; i++){
            List<Integer> level = new ArrayList<Integer>();
            
            int x = i, y = 0;
            while(x >= 0 && y < col){
                level.add(array[x][y]);
                x--;
                y++;
            }
            
            res.add(level);
        }
    }
}
