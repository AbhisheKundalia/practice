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
        boolean[] visited = new boolean[n];
        int level = 0;
        int prePos = n+1;
        List<String[]> res = new ArrayList<String[]>();
        String[] prevRes = new String[n];
        
        solveNQueens0(level, visited, prePos, prevRes, res);
        
        return res;
    }
    
    public void solveNQueens0(int level, boolean[] visited, int prePos,String[] prevRes, List<String[]> res){
         int n = visited.length;
         char[] s = new char[n];
           
         for(int j = 0; j < n; j++) s[j] = '.';
           
         for(int i = 0; i < n; i++){
               if(!visited[i] && Math.abs(prePos - i) > 1){
                   visited[i] = true;
                   s[i] = 'Q';
                   String t = String.copyValueOf(s);                  
                   prevRes[level] = t;
                   
                   if(level+1 == n) {
                       res.add(prevRes);
                   }else{
                      solveNQueens0(level+1, visited, i, prevRes, res);
                   }
                   s[i] = '.';
                   visited[i]=false;
                  
               }     
           }
    }
    
    public int totalNQueens(int n) {
           int total = 0;
           
           for(int i = 0; i < n; i++){
               ArrayList<Integer> tmp = new ArrayList<Integer>();
               tmp.add(i);
               total += totalNq(tmp, 1, n);
           }
           
           return total;      
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
