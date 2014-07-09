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
        
        int i = 0;
        while( i < num.length){
          int len = res.size();
          int start = 0;
          
          if(i>0 && num[i] == num[i-1]){
              start = len - prev;
          }
          
          for(int j = start; j < len; j++){
              List<Integer> tmp = new ArrayList<Integer>(res.get(j));
              tmp.add(num[i]);
              res.add(tmp);
          }
              prev = len - start;
              
          i++;
          
        }
        
        return res;
    }
}
