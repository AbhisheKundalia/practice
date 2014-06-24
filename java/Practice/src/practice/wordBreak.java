/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.*;
/**
 *
 * @author admin
 */
public class wordBreak {
     public boolean wordBreak(String s, Set<String> dict) {
        s = s.trim();
         if(s.isEmpty()){
             return true;
         }
         
         for(String t : dict){
            if(s.contains(t)){
                int index = s.indexOf(t);
                
                String beginPart = index > 0 ? s.substring(0,index-1) : "";
                String endPart = index + t.length() < s.length()? s.substring(index + t.length()) : "";
                
                boolean result = wordBreak(beginPart, dict)&&wordBreak(endPart,dict);
               
                if (result){
                    return true;
                }
            }
        }
         
         return false;
    }
     
     public boolean wordBreak2(String s, Set<String> dict) {
        s = s.trim();
         if(s.isEmpty()){
             return true;
         }
         
         for(int i = 1; i <= s.length(); i++){
             String t = s.substring(0, i);
             String endPart = i < s.length() ? s.substring(i) : "";
             
             if(dict.contains(t)){
                 boolean result = wordBreak2(endPart, dict);
                 if(result){
                     return true;
                 }
             }
         }
         
         return false;
    }
     
      public boolean wordBreak3(String s, Set<String> dict) {
         int length = s.length();
         
         boolean[] possible = new boolean[length+1];
        
         possible[0] = true;  
         for(int i = 1; i <= length; i++){
             for(int k = 0; k < i; k++){
                 possible[i] = possible[k] && dict.contains(s.substring(k+1, i));
                 if(possible[i]) break;
             }
         }
         
         return possible[length];
    }
      
     
}
