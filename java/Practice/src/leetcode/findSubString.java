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
public class findSubString {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
       
       if(L.length < 1) return res;
       
       HashMap<String, Integer> indexes = new HashMap<String, Integer>();      
       int len = L[0].length();
       int beginindex = 0;
       int t = 0;
       
       for(int i = 0; i < L.length; i++){
           int count = 1;
           
           if(indexes.containsKey(L[i])){
              count += indexes.get(L[i]);
           }
           
           indexes.put(L[i], count);
       }
       
       while(t < S.length() - len*L.length){
            String 
       }
       
       return res;
       
    }
}
