/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] path = new int[n];
        path[0] = 1;
        
        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                 path[j] = path[j-1] + path[j];
            }
        }
        
        return path[n-1];
    }
}
