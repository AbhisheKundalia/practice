/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class isScramble {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] a1 = new int[26];
        
        for(int i = 0; i < s1.length(); i++){
            a1[s1.charAt(i) - 'a']++; 
        }
        
         for(int i = 0; i < s1.length(); i++){
            a1[s2.charAt(i) - 'a']--; 
        }
        
          for(int i = 0; i < 26; i++){
           if(a1[i] != 0) return false; 
        }
        
        if(s1.length() == 1) return true; // this is the initial condition
           
        for(int i = 1; i < s1.length(); i++){
            if(isScramble(s1.substring(0,i), s2.substring(0, i)) && isScramble(s1.substring(i),s2.substring(i)) 
                || isScramble(s1.substring(0,i), s2.substring(s1.length()-i)) && isScramble(s1.substring(i),s2.substring(0, s1.length() - i)) ){
                return true;
            }
        }
        
     return false;   
    }
      
}
