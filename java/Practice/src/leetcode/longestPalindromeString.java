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
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            int index1 = i, index2 = i;
            
            while(index1 <= index2 && index1 >= 0 && index2 < n && s.charAt(index2) == s.charAt(index1)){     
                index1--;
                index2++;
            }
            
            if(index2 > index1) {
                if(palindrom.length() < (index2 - index1 - 1)){
                    palindrom = s.substring(index1+1, index2);
                }
            }
            
            index1 = i;
            index2 = i+1;
            
            while(index1 <= index2 && index1 >= 0 && index2 < n && s.charAt(index2) == s.charAt(index1)){     
                index1--;
                index2++;
            }
            
            if(index2 > index1 + 1) {
                if(palindrom.length() < (index2 - index1 - 1)){
                    palindrom = s.substring(index1+1, index2);
                }
            }      
        }
        
        return palindrom;
    }
}
