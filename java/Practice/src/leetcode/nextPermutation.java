/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class nextPermutation {
    public void nextPermutation(int[] num) {
        int len = num.length;
        int point = len - 1;
        
       while(point > 0 && num[point - 1] >= num[point]) point--;
       
       if(point > 0){
           int index = len - 1;
           
           while(index >= point && num[index] <= num[point - 1]) index--;
           
           num[point - 1] = num[point-1]^num[index];
           num[index] = num[point - 1]^num[index];
           num[point - 1] = num[point - 1]^num[index];
       }
       
       int start = point;
       int end = len - 1;
       
       while(start < end){
           num[start] = num[start]^num[end];
           num[start] = num[start]^num[end];
           num[end] = num[start]^num[end]; 
           start++;
           end--;
       }
    }
}
