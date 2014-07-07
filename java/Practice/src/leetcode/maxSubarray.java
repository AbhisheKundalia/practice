/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class maxSubarray {
    public int maxSubArray(int[] A) {
        int maxSum = 0;
        int sum = 0;
        int i = 0;
        
        while(i < A.length && A[i] <= 0){
            i++;
        }
        
        while(i < A.length){
            while( i < A.length && A[i] >= 0){
                sum +=A[i];
                i++;
            }
            
            maxSum = maxSum > sum? maxSum : sum;
            
            while( i < A.length && A[i] <= 0){
                sum +=A[i];
                i++;
            }
            
            if(sum <= 0){
                sum = 0;
            }
        }
     
        return maxSum;
    }
    
    public int maxSubArray1(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i < A.length; i++){
           sum += A[i];
           
           maxSum = maxSum > sum? maxSum : sum;
           
           if( sum < 0 ){
               sum = 0;
           }
        }
     
        return maxSum;
    }
}
