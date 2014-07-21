/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;

/**
 *
 * @author admin
 * 
 * 这道题是由一道经典题目演变。
 * 给出两个string. 判定S是否由l的所有的字母组成
 * 
 */

public class findSubString {
    public List<Integer> findwords(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
       
       if(L.length < 1) return res;
       int len = L[0].length();
       
       if(S.length() < len*L.length) return res;
        
       HashMap<String, Integer> tmp = new HashMap<String, Integer> ();
        
        for(int i = 0; i < L.length; i++){
            if(!tmp.containsKey(L[i])){
                tmp.put(L[i], 1);
            }else{
                tmp.put(L[i], tmp.get(L[i]) + 1);
            }
        }
        
       int startIndex = 0;
       int currIndex = 0;
       
       while(startIndex < S.length() - len*L.length && currIndex < S.length()){
            String word = S.substring(currIndex, currIndex + len);
            
            if(tmp.containsKey(word)){
                if(tmp.get(word) == 0){
                    
                    if(currIndex - startIndex == len*L.length) res.add(startIndex);
                    
                    while(startIndex < currIndex && !S.substring(startIndex, startIndex + len).equals(word)){
                        tmp.put(S.substring(startIndex, startIndex), tmp.get(S.substring(startIndex, startIndex+len) + 1));
                    }
                    
                    startIndex += len;
                    
                }else{
                    tmp.put(word, tmp.get(word) - 1);
                }
                
                currIndex += len;
                
            }else{
            
            startIndex++;
            currIndex = startIndex; 
            }
       }
       
       if(currIndex == S.length() && currIndex - startIndex == len*L.length ) res.add(startIndex);
       
       return res;
       
    }
    
     public List<Integer> findwords2(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
       
       if(L.length < 1) return res;
       int len = L[0].length();
       
       if(S.length() < len*L.length) return res;
      
       HashMap<String, Integer> tmp = new HashMap<String, Integer> ();
       for(int i = 0; i < L.length; i++){
            if(!tmp.containsKey(L[i])){
                tmp.put(L[i], 1);
            }else{
                tmp.put(L[i], tmp.get(L[i]) + 1);
            }
        }
       
       boolean[] isWord = new boolean[S.length()];
       
       for(int i = 0; i < S.length() - len; i++){
          if(tmp.containsKey(S.substring(i, i + len))) 
              isWord[i] = true;
       }
       
       for(int j = 0; j < S.length() - len*L.length; j++){
           
           for(int t = 0; t < L.length; t++){
               if(!isWord[j+t*len]){
                   break;
               }
           }
       }
       return res;
     }
     
    public boolean findAllWords(String S, String[] L){
        
        if(S.length() != L.length * L[0].length()) return false;
        int len = L[0].length();
        HashMap<String, Integer> tmp = new HashMap<String, Integer> ();
        
        for(int i = 0; i < L.length; i++){
            if(!tmp.containsKey(L[i])){
                tmp.put(L[i], 1);
            }else{
                tmp.put(L[i], tmp.get(L[i]) + 1);
            }
        }
        
        for(int j = 0; j < S.length();){
            if(tmp.containsKey(S.substring(j, j + len))){
                int num = tmp.get(S.substring(j, j+ len));
                if(num > 1){
                    tmp.put(S.substring(j, j+ len), num-1);
                }else{
                    tmp.remove(S.subSequence(j, j + len));
                }
            }else{
                return false;
            }
            
            j += len;
        }
        
       return true;
    }
    
    
    public List<Integer> findSubstring(String S, String L) {  
          List<Integer> res = new ArrayList<Integer>();
          
          if(S.length() < L.length()) return res;
       
        for(int j = 0; j < S.length() - L.length(); j++){
            if(isSimilarString(S.substring(j, j+L.length()), L)){
                res.add(j);
            }    
        }
        
       return res;
       
    }
    
    public boolean isSimilarString(String S, String L){
        if(S.length() != L.length()) return false;
        int[] tmp = new int[26];
        
        for(int i = 0; i < S.length();i++){
            tmp[S.charAt(i) - 'a']++;
        }
        
         for(int i = 0; i < S.length();i++){
            tmp[L.charAt(i) - 'a']--;
        }
         
          for(int i = 0; i < S.length();i++){
           if(tmp[i] != 0) return false;
        }
          
          return true;
    }
}
