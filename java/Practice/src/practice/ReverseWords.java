/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author admin
 */
public class ReverseWords {
    public String reverseWords(String s){
         String result = "";
         
        if(s == null)
        {
            return result;   
         }
        
        String[] words = s.trim().split("\\s+");
        
        for(int i = words.length; i > 0; i--){
            result+=words[i-1] + " ";
        }
        
        return result.trim();
    }
}
