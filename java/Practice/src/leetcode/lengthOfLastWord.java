/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class lengthOfLastWord {
     public int lengthOfLastWord(String s) {
        int length = s.length();
        int len = 0;
        
        int i = length - 1;
        while( i >= 0 && s.charAt(i) == ' '){
            i++;
        }
        
        while(i >= 0 && s.charAt(i) != ' '){
             i++;
             len++;
         }
            
        
        return len;
    }
}
