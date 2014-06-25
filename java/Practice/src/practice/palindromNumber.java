/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author admin
 * 
 * points : the negative number is not palindromNumber
 * 
 */
public class palindromNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int x0 = x;
        int y = 0;
        while(x0!=0){
            y = y*10 + x0%10;
            x0 = x0/10;
        }
        
        return x==y;
    }
}
