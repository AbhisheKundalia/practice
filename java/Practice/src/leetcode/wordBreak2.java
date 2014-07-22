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
     
     //Here I used the BSF, then it listed all possibility
      public List<String> wordBreak3(String s, Set<String> dict) {
             HashMap<Integer,List<String>> tmp = new HashMap<Integer,List<String>> ();
             Queue<Integer> indexes = new LinkedList<Integer>();
             
             List<String> res = new ArrayList<String>();           
             int n = s.length();
             
             boolean[] possible = new boolean[n];
             
             for(int i = 0; i < n; i++){
                 if(dict.contains(s.substring(0, i+1))){                                       
                     List<String> tmp0 = new ArrayList<String>();
                     tmp0.add(s.substring(0, i+1));
                     tmp.put(i+1, tmp0);
                     indexes.add(i+1);
                 }
             }
             
             while(!indexes.isEmpty()){
                
                 int index = indexes.poll();
                 List<String> tmp0 = new ArrayList<String>(tmp.get(index));
                 tmp.remove(index);
                 
                 for(int j = index; j < n; j++){
                     if(dict.contains(s.substring(index, j+1))){  
                         List<String> newS = new ArrayList<String>();
                         
                         for(int t = 0; t < tmp0.size(); t++){
                             newS.add(tmp0.get(t) + " " + s.substring(index, j+1));
                         }
                         
                         if(j+1 == n){
                             res.addAll(newS);
                             continue;
                         }
                         
                         if(tmp.containsKey(j+1)){
                             List<String> value = new ArrayList<String>(tmp.get(j+1));
                             value.addAll(newS);
                             
                             tmp.put(j+1, value);
                         }else{
                             
                             indexes.add(j+1);
                            
                             tmp.put(j+1, tmp0);
                         }      
                    } 
                }
             }
               
             return res;
      }
      
      //if we use the DSF, and record we have visited    
      public List<String> wordBreak2(String s, Set<String> dict) {
         int n = s.length();
         boolean[] possibility = new boolean[n+1]; 
         List<String> res = new ArrayList<String>();
         String result = "";
         
         wordBreakProb(s, dict, result, 0, n, possibility,res);
         
         return res;             
     } 
      
      public void wordBreakProb(String s, Set<String> dict, String result, int start, int len,  boolean[] possibility, List<String> res){
          if(start == len){
              res.add(result.trim());
              return;
          }
          
          for(int i = start; i < len; i++){
              if(dict.contains(s.substring(start, i+1)) && !possibility[i+1]){
                  int size = res.size();
                  wordBreakProb(s, dict, result+" "+s.substring(start, i+1),i+1,len, possibility, res);
                  if(res.size() == size) possibility[i+1] = true;
              }
          }
          
          
      }
     
}
