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
public class combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(n < k || k == 0 ) return res;
        
        List<Integer> first = new ArrayList<Integer>();
        first.add(0);
        res.add(first);
        
        for(int i = 0; i < k; i++){
            int size = res.size();
            int j = 0;
            while( j < size){
                List<Integer> tmp = new ArrayList<Integer>(res.get(0));
                int startInteger = tmp.get(tmp.size()-1);
                
                if(startInteger == 0) tmp.clear();
                
                for(int t = startInteger + 1; t <= n-k+1+i; t++){
                    List<Integer> tmp0 = new ArrayList<Integer>(tmp);
                    tmp0.add(t);
                    res.add(tmp0);
                }
                
                res.remove(0);
                j++;
            }
        }
        
        return res;
    }
}
