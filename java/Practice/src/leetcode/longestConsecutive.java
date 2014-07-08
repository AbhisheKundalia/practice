/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;

/**
 *
 * @author admin
 */
public class longestConsecutive {
    public int longestConsecutive(int[] num) {
        Arrays.sort(num);
        int max = 0;
        int len = 1;
        
        for(int i = 0; i < num.length - 1; i++){
            if(num[i] == num[i+1] - 1){
                len++;
            }else if(num[i] < num[i+1] - 1){
                max = len > max? len : max;
                len = 1;
            }
        }
        
        max = max > len ? max : len;
        return max;
    }
}
