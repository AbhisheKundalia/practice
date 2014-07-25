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
       HashMap<String, Integer> tmp = new HashMap<String, Integer>();

       for(int i = 0; i < strs.length; i++){     
           String key = getKey(strs[i]);
           
           if(tmp.containsKey(key)){
                if(tmp.get(key) != -1){
                   res.add(strs[tmp.get(key)]);
                   tmp.put(key, -1);
               }
               res.add(strs[i]);
              
           }else{
               tmp.put(key, i);
           }
       }
       
       return res;
    }
    
    public String getKey(String str){
        int[] count = new int[26];
        String res = "";
        
        for(int i = 0; i < str.length(); i++){
            count[str.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                res += count[i] + String.valueOf(Character.toChars(i+'a')) ;
            }
        }
        
        return res;
    }
    
    public List<String> anagrams2(String[] strs) {
       List<String> res = new ArrayList<String> ();
       HashMap<String, Integer> temp = new HashMap<String, Integer>();

       for(int i = 0; i < strs.length; i++){
          
          char[] tmp0 = strs[i].toCharArray();
          Arrays.sort(tmp0);
          
           String key = String.valueOf(tmp0);
           
           if(temp.containsKey(key)){
              
               
                if(temp.get(key) != -1){
                   res.add(strs[temp.get(key)]);
                   temp.put(key, -1);
               }
               res.add(strs[i]);
              
           }else{
               temp.put(key, i);
           }
       }
       
       return res;
    }
    
}
