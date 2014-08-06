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
public class subsets {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        List<Integer> first = new ArrayList<Integer>();
        res.add(first);
        
        Arrays.sort(num);
        int prev = 0;
      
        for(int i = 0; i < num.length; i++){
          int len = res.size();
          int start = 0;
          
          if(i>0 && num[i] == num[i-1]){
              start = len - prev;
          }else{
              prev = len;
          }
               
          for(int j = start; j < len; j++){
              List<Integer> tmp = new ArrayList<Integer>(res.get(j));
              tmp.add(num[i]);
              res.add(tmp);
          }
        }
        
        return res;
    }
    
    public List<List<Integer>> subsets(int[] S) {
         Arrays.sort(S);
         
         List<List<Integer>> res = new ArrayList<List<Integer>> ();
        
         List<Integer> tmp = new ArrayList<Integer>();
         res.add(tmp);
        
         for(int i = 0; i < S.length; i++){
             int size = res.size();
             
             for(int j = 0; j < size; j++){
                 List<Integer> newSet = new ArrayList<Integer> (res.get(j));
                 newSet.add(S[i]);
                 res.add(newSet);
             }
         }
         
         return res;
    }
}
