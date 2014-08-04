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
public class singleNumber {
     public int singleNumber(int[] A) {
         if(A.length < 1){
             return 0;
         }
        
        int result = A[0];
        for(int i = 1; i < A.length; i++){
           result ^= A[i];
        }
        
        return result;
    }
     
     public int singleNumberII(int[] A) {
        Hashtable<Integer, Integer> count = new Hashtable<Integer, Integer>();
        
        int result = 0;
        
        for (int i = 0; i < A.length; i++){
            int num = 1;
            if(count.containsKey(A[i])){
                num = count.get(A[i]) + 1;
            }
            
            if( num < 3 ){
                result ^= A[i];
                count.put(A[i], num);
            }
        }
        
        return result;
    }
     
     public int singleNumberII2(int[] A) {
        int result = 0;
        
        for (int i = 0; i < 32; i++){
            int num = 0;
             
            for(int j = 0; j < A.length; j++){
                num += ((A[j]>>i) & 1);
            }
          
            result |= ((num%3)<<i);
        }
        
        return result;
    }
     
     
}
