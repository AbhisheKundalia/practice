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
public class wordBreak2 {
     public List<String> wordBreak(String s, Set<String> dict) {
       HashMap<Integer, List<String>> combPattens = new HashMap<Integer, List<String>>();
       List<String> com = new ArrayList<String>();
       
       s = "#";
       int len =  s.length();
       
       boolean[] possibility = new boolean[len];
       possibility[0] = true;
       com.add("");
       combPattens.put(0, com);
       
       for(int i = 1; i < len; i++){
          com.clear();
         
           for(int j = 0; j < i ; j++){
              String adds = s.substring(j+1, i+1);
               possibility[i] = possibility[j] && dict.contains(adds);
               
               if(possibility[i]){
                   for(String t : combPattens.get(j)){
                       com.add(t.trim() + " " + adds);
                   }
                   
               }
           }
           
           if(!com.isEmpty()) combPattens.put(i, com);
       }
       
       return combPattens.get(len - 1);
    }
      public List<String> wordBreak2(String s, Set<String> dict) {
             List<String> res = new ArrayList<String> ();
             
             for(int i = 0; i < s.length(); i++){
                 String word = s.substring(0,i+1);
                 
                 if(dict.contains(word)){
                     List<String> res0 = new ArrayList<String>();
                     
                     if(i+1 == s.length()) {
                         res.add(word);
                         break;
                     }
                      
                     res0 = wordBreak2(s.substring(i+1), dict);
                     
                     for(int j = 0; j < res0.size(); j++){
                         res.add(word + " " + res0.get(j));
                     }
                     
                    
                 }
             }
             
             return res;
      }
     
}
