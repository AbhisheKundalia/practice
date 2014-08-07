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
public class Triangle {
    //BSF . from bottom to top would be better choice then from top to the bottom
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> total = new ArrayList<Integer>();
        
        for(int i = triangle.size() - 1; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
               int mintotal = 0;
               if(total.size() > triangle.get(i).size()){
                   mintotal = Math.min(total.get(j), total.get(j+1));
                   total.set(j, triangle.get(i).get(j) + mintotal);
               }else{
                   total.add(triangle.get(i).get(j) + mintotal);  
               }
            }
        }
               
        return total.get(0);
    }
}
