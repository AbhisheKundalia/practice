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
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        
        combination(candidates, 0, target, res, solution);
        
        return res;
    }
    
    public void combination(int[] candidates, int startIndex, int target, List<List<Integer>> res, List<Integer> solution){
        if(target == 0){
            List<Integer> tmp = new ArrayList<Integer>(solution);
            res.add(tmp);
            return;
        }
        
        for(int i = startIndex; i < candidates.length; i++){
            if(candidates[i] <= target){
                solution.add(candidates[i]);
                combination(candidates, i, target - candidates[i], res, solution);
                solution.remove(solution.size() - 1);
            }else break;
        }
    }
    
    public void combinationUniq(int[] candidates, int startIndex, int target, List<List<Integer>> res, List<Integer> solution){
        if(target == 0){
            List<Integer> tmp = new ArrayList<Integer>(solution);
            res.add(tmp);
            return;
        }
        
        for(int i = startIndex; i < candidates.length; i++){
            if(candidates[i] <= target){
                solution.add(candidates[i]);
                combination(candidates, i+1, target - candidates[i], res, solution);
                solution.remove(solution.size() - 1);
                
                while(i < candidates.length - 1 && candidates[i] == candidates[i+1]) i++;
            }else break;
        }
    }
}
