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
public class minumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int minTotal = 0;
        
        if(triangle.size() < 1) return minTotal;
        
        minTotal = triangle.get(0).get(0);
        
        for(int i = 1; i < triangle.size(); i++){
            
            int firstTotal = triangle.get(i - 1).get(0) + triangle.get(i).get(0);
            triangle.get(i).set(0, firstTotal);
            int j = 1;
            
            if(i == triangle.size() - 1) minTotal = firstTotal;
            
            for(;j < triangle.get(i).size() - 1; j++){
                int min = Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)) + triangle.get(i).get(j);
                triangle.get(i).set(j, min);
                
                 if(i == triangle.size() - 1) minTotal = minTotal > min? min : minTotal;
            }
            
            int lastTotal = triangle.get(i - 1).get(j-1) + triangle.get(i).get(j);
            triangle.get(i).set(j, lastTotal);
            
              if(i == triangle.size() - 1) minTotal = minTotal > lastTotal? lastTotal : minTotal;
        }
       
        return minTotal;
    }
}
