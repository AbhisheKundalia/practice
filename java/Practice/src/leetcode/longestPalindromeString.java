/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class longestPalindromeString {
    public String longestPalindrome(String s) {
         String palindrom = "";
        int maxLen = 0;
        
        int index1 = 0, index2 = 0;
        int i = 0;
        while(i < 2*s.length()){
            index1 = i/2;
            index2 = i/2 + i%2;// this is important.
            
            while(index1 >= 0 && index2 < s.length() && s.charAt(index2) == s.charAt(index1)){     
                index1--;
                index2++;
            }
            
            if(index2 > index1 && maxLen < (index2 - index1 - 1)) {
                palindrom = s.substring(index1+1, index2);
                maxLen = index2 - index1 - 1; 
            }
            
            i++;
        }
        
        return palindrom;
    }
}
