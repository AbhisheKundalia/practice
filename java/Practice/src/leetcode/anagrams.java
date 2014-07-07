/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;
/**
 *
 * @author admin
 */
public class anagrams {
    public List<String> anagrams(String[] strs) {
       List<String> res = new ArrayList<String> ();
       HashMap<String, String> temp = new HashMap<String, String>();
       
       for(int i = 0; i < strs.length; i++){
           String key = getKey(strs[i]);
           
           if(temp.containsKey(key)){
               String value = temp.get(key);
               
                if(!res.contains(value)){
                   res.add(value);
               }
               res.add(strs[i]);
              
           }else{
               temp.put(key, strs[i]);
           }
       }
       
       return res;
    }
    
    public String getKey(String str){
        int[] temp = new int[26];
        String res = "";
        
        for(int i = 0; i < str.length(); i++){
            temp[str.charAt(i) - 'a'] += 1;
        }
        
        for(int i = 0; i < 26; i++){
            if(temp[i] > 0){
                res += temp[i];
                res += String.valueOf(Character.toChars(i+'a'));
            }
        }
        
        return res;
    }
}
