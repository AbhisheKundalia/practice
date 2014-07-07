/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;


import java.util.*;

/**
 *
 * @author admin
 * 
 * 
 * DP Problem
 * 
 * BFS -- only related with the pre-level
 */
public class jumpGame2 {
    public int jump(int[] A) {
        return jump1(A, 0);
    }
    
    public int jump1(int[]A, int index){
        if(index >= A.length - 1) return 0;
         int minStep = A.length - index;
         
         if(A[index] + index >= A.length - 1) return 1;
         
         for(int i = 1; i <= A[index]; i++){
             int step = jump1(A, index+i)+1;
             minStep = Math.min(minStep, step);
         }
        
         return minStep;
    }
    
    public int jump2(int[] A){
        int[] minSteps = new int[A.length];
        minSteps[0] = 0;
        
        for(int i = 0; i < A.length - 1; i++){
            for(int j = i + A[i]; j > i; j--){
               if(j >= A.length - 1) return (1 + minSteps[i]);
               
               if(minSteps[j] == 0){
                   minSteps[j] = minSteps[i] + 1;
               }
            }
        }
        
        return minSteps[A.length - 1];
    }
    
    public int jump3(int[] A){        
        if(A.length < 2) return 0;
         int minSteps = 1;
        int currEnd = A[0];
        int nextEnd = currEnd;
        
        for(int i = 1; i < A.length; i++){
            if(currEnd >= A.length - 1) return minSteps;
         
            nextEnd = Math.max(nextEnd, i + A[i]);
            
            if(i == currEnd) 
            {
                minSteps++;
                currEnd = nextEnd;
            }
        }
          
       return minSteps;
    }
    
    
}
