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
public class longestValidParenthesis {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> index = new Stack<Integer>();
        Stack<Character> temp = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')' && !temp.isEmpty() && temp.peek() == '('){
                index.pop();
                temp.pop();
                continue;
            }
            
            index.push(i);
            temp.push(s.charAt(i));          
        }
        
        int end = s.length();
        
        while(!index.isEmpty()){
            int index0 = index.pop();
            maxLen = maxLen > (end - index0 - 1)?maxLen : end - index0 - 1;
            end = index0;
        }
        
        maxLen = maxLen > end? maxLen : end;
             
        return maxLen;
    }
}
