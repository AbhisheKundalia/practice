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
public class longestConsecutive {
    public int longestConsecutive(int[] num) {
        Arrays.sort(num);
        int max = 0;
        int len = 1;
        
        for(int i = 0; i < num.length - 1; i++){
            if(num[i] == num[i+1] - 1){
                len++;
                i++;
            }else if(num[i] < num[i+1] - 1){
                max = len > max? len : max;
                len = 1;
            }
        }
        
        max = max > len ? max : len;
        return max;
    }
    
     public int longestConsecutive2(int[] num) {
       HashMap<Integer, Boolean> tmp = new HashMap<Integer, Boolean>();
       int maxLen = 0;
       
       for(int i = 0; i < num.length; i++){
           tmp.put(num[i], true);
       }
       
       for(int i = 0; i < num.length; i++){
           int len = 0;
           int num0 = num[i];
           
           while(tmp.containsKey(num0) && tmp.get(num0)){
               len++;
               tmp.put(num0, false);
               num0++;
           }
           
           num0 = num[i]-1;
     
            while(tmp.containsKey(num0) && tmp.get(num0)){
               len++;
               tmp.put(num0, false);
               num0--;
           }
           
           maxLen = Math.max(len, maxLen);
       }
       
       return maxLen;
    }
}
