/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;

/**
 *
 * @author admin
 * 
 * DP: 1. find the subset 
 *     2. Recursion
 *     3. non-recursion
 *     
 */
public class NQueens {
    public List<String[]> solveNQueens(int n) {
        List<String []> res = new ArrayList<String []>();
        int[] solution = new int[n];
    
        String[] curr = new String[n];
        Nqueen1(1, solution, curr, res);
        return res;
    }
    
    public void Nqueen1(int level, int[] solution, String[] curr, List<String []> res){
        
        if(level == solution.length + 1){
            res.add(Arrays.copyOf(curr, level-1));
            return;
        }
        
        for(int i = 1; i <= solution.length; i++){
            int slop0 = Math.abs(i - level);
            
                int j = 0; 
                while(j < level && solution[j] != i && Math.abs(j - level) != Math.abs(solution[j] - i)){
                    j++;
                }
                
                if(j == level){
                    String tmp = "";
                    
                    for(int t = 1; t <= solution.length; t++){
                        if(t==i) tmp += "Q";
                        else tmp += ".";
                    }
                    
                   
                    solution[level-1] = i;
                    curr[level-1] = tmp;
                    Nqueen1(level + 1, solution, curr, res);
                    solution[level - 1] = 0;
                    curr[level - 1] = ""; 
                }
         }
    }
    
    
    public int totalNQueens(int n) {

        ArrayList<Integer> solution = new ArrayList<Integer> ();
           
        return totalNq(solution, 0, n);
               
    }
    
    public int totalNq(ArrayList<Integer> orders, int level, int n){
           int total = 0;
           
           if(level == n) {
               return 1;
           }else{
               for(int col = 0; col < n; col++){  
                   if(!orders.contains(col)){              
                       int j = 0;
                       while(j < level && Math.abs(j - level) != Math.abs(orders.get(j) - col) ){              
                           j++;
                       }
                       
                       if( j == level){
                           orders.add(level, col);
                           total +=totalNq(orders, level + 1,n); 
                           orders.remove(level);
                       }
                   }
               }
           } 
           
           return total;
    }
    
    
}
