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
public class grayCode {
     public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        
        for(int i = 0; i < n; i++){
            int size = res.size();
            int add = (int)Math.pow(2.0, i);
            
            for(int j = size; j > 0; j--){
                res.add(res.get(j-1) + add);
            }
        }
        
        return res;
    }
}
