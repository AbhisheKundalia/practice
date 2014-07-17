/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 * 
 * 在位置i 上可以得到的water是leftmostheight vs rightmostheigh - A[i]
 * 
 */
public class trapRainWater {
     public int trap(int[] A) {
        int n = A.length;
        int[] rightmostheight = new int[n];
        int max = 0;
        int total = 0;
        
        for(int j = n-1; j >=0; j--){
             max = Math.max(max, A[j]);
            rightmostheight[j] = max;
        }
        
        max = 0;
         
        for(int i = 0; i < n; i++){
            max = Math.max(max, A[i]);
            total += Math.min(rightmostheight[i], max) - A[i];
        }
        
        return total;
    }
}
