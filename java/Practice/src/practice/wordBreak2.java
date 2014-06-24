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
}
