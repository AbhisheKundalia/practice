/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.*;
/**
 *
 * @author admin
 * 
 * The main point : how to check overflow and underflow
 */
public class atoi {
     public int atoi(String str) {
        int sign = 1;
        long result = 0;
        
        if(!str.matches("\\s*[+-]?\\d+.*")){
            return 0;
        }
        
        int i = 0;
        str=str.trim();
        if(str.charAt(0) == '-') sign = -1;
        if(str.charAt(0) == '-' || str.charAt(0) == '+'){
            i = 1;
        }
        
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            result = result*10 + sign*(str.charAt(i) - '0');
            
            if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            
            i++;
        }
        
        return (int) result;
    }
}
