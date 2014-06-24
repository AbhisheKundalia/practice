/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

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
        
        for(int i = 1; i < A.length; i++){
            A[i] ^= A[i-1];
        }
        
        return A[A.length-1];
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
     
     
}
