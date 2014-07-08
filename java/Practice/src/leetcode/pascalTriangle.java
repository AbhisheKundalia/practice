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
public class pascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();       
        List<Integer> first = new ArrayList<Integer>();
        if(numRows < 1) return res;
        
        first.add(1);
        res.add(first);
        
        for(int i = 1; i < numRows; i++){
            List<Integer> prev = new ArrayList<Integer>();
            prev = res.get(i - 1);
            
            List<Integer> curr = new ArrayList<Integer>();
            
            for(int j = 0; j <= prev.size(); j++){
                int num = 0;
                
                if(j < prev.size()) num += prev.get(j);
                if(j > 0) num += prev.get(j-1);
                
                curr.add(num);
            }
            
            res.add(curr);
        }
        
        return res;
    }
    
    public List<Integer> getRow(int rowIndex) {
       List<Integer> res = new ArrayList<Integer>();
       
       for(int i = 0; i <= rowIndex; i++){       
           int temp = 0;
           
           for(int j = 0; j < res.size(); j++){
               int temp1 = res.get(j);
               res.set(j, temp1 + temp);
               temp = temp1;
           }
           
           if(temp == 0){
               res.add(1);
           }else{
               res.add(temp);
           }
       }
       
       return res;
    }
      
}
