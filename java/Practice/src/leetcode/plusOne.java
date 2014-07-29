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
 * main idea : significant number operation : +/-
 * 
 * 
 */
public class plusOne {
    public int[] plusOne(int[] digits) {
        int add = 1;
        int len = digits.length;
        
        for(int i = len - 1; add > 0 && i >= 0; i--){
            digits[i] = (digits[i] + add)%10;
            add = (digits[i] + add)/10;
        }
        
        if( add > 0 ){
            
            int[] result = new int[len + 1];
            result[0] = add;
            
            for(int i = 1; i <= len; i++){
                result[i] = digits[i-1];
            }
            return result;
        }
       
        return digits;
    }
}
