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
public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> combSum = new ArrayList<List<Integer>>();
        HashMap<List<Integer>, Integer> prevSum = new HashMap<List<Integer>, Integer>();
        
        for(int i = 0; i < candidates.length; i++){
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            
            for(int j = 1; j < target/candidates[i]; j++){
              
            }
        }
    }
}
