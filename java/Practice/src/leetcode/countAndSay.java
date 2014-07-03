/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class countAndSay {
     public String countAndSay(int n) {
        if( n < 1) return "";
        
        String s = "1";
        
        for(int i = 1; i < n; i++){
            int count = 1;
            String nextS = "";
            
            for(int j = 1; j < s.length(); j++){
                if(s.charAt(j) == s.charAt(j - 1)){
                    count++;
                }else{
                    nextS += count + s.substring(j-1, j); 
                    count = 1;
                }
            }
            
            nextS += count + s.substring(s.length() - 1);
            s= nextS;
        }
        
        return s;
    }
}
