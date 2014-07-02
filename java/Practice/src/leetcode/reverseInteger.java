/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 * 
 * overflow and underflow => use long to deal with it
 * 
 */
public class reverseInteger {
     public int reverse(int x) {
        long reversedInt = 0;
        
        while(x!=0){
            reversedInt = reversedInt * 10 + x%10;
            x = x/10;
            if(reversedInt >= Integer.MAX_VALUE) return Integer.MAX_VALUE;     
            if(reversedInt <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        
        return (int) reversedInt;
    }
}
