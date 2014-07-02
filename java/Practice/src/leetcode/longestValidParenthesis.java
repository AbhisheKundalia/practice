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
        int startIndex = 0;
        Stack<Integer> index = new Stack<Integer>();
        Stack<Character> temp = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
            if(index.isEmpty() && s.charAt(i) == ')'){
                maxLen = maxLen > i - startIndex? maxLen : i - startIndex;
                startIndex = i+1;
            }else if(!index.isEmpty()){
                
            char top = temp.peek();
            if(top == ')'){
                index.pop();
                temp.pop();
            }else if(s.charAt(i) == ')'){        
                     index.pop();
                     temp.pop();
                     continue;
            }
            }
            
            index.push(i);
            temp.push(s.charAt(i));
            
        }
        
        
        
        return maxLen;
    }
}
