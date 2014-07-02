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
public class generateParenthesis {
     public List<String> generateParenthesis(int n) {
        Queue<String> currQ = new LinkedList<String>();
        Queue<Integer> totalQ = new LinkedList<Integer>();
        List<String> res = new ArrayList<String> ();
        
        currQ.add("(");
        totalQ.add(1);
        
        while(!currQ.isEmpty()){
            String curr = currQ.poll();
            int total = totalQ.poll();
            
            if(curr.length() == 2*n){
                res.add(curr);
                continue;
            }
            
            if(total == 0){
                currQ.add(curr + "(");
                totalQ.add(total+1);
                continue;
            }
            
            if(curr.length() + total < 2*n ){
                 currQ.add(curr + "(");
                totalQ.add(total+1);
            }
            
             currQ.add(curr + ")");
             totalQ.add(total-1);
        }
        
        return res;
    } 
}
