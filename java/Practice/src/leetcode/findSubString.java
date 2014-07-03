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
       
       List<String> strings = new ArrayList<String>();
       
       int len = L[0].length();
       int index = 0;
       
       while(index < S.length() - len){
           String t = S.substring(index, index + len);
           boolean find = false;
           for(int i = 0; i < L.length; i++){
               if(L[i].equalsIgnoreCase(t)){
                   find = true;
                   break;
               }
           }
           
           if(find){
               if(strings.isEmpty() || strings.contains(t)){
                   res.add(index);
                   strings.clear();
                }
               
               index += len;
               strings.add(t);
               
           }else{
                strings.clear();
                index++;
           }
       }
       
       return res;
       
    }
}
