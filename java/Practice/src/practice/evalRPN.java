/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.Stack;

/**
 *
 * @author admin
 */
public class evalRPN {
    public int evalRPN(String[] tokens){
        int result = 0;
        if(tokens.length == 0){
            return result;
        }
        
        Stack st = new Stack();
        for(String token : tokens){
           if(token.matches("\\*|\\+|-|/")){
               int tmp0 = (Integer) st.pop();
               int tmp1 = (Integer) st.pop();
               int tmp = 0;
               
               switch(token){
                   case "+":
                       tmp = tmp1 + tmp0;
                       st.push(tmp);
                       break;
                   case "-":
                       tmp = tmp1 - tmp0;
                       st.push(tmp);
                       break;
                   case "*":
                       tmp = tmp1 * tmp0;
                       st.push(tmp);
                       break;
                   case "/":
                       tmp = tmp1 / tmp0;
                       st.push(tmp);
                       break;
                   default:
                       break;
               }
           }else{
               st.push(Integer.valueOf(token));
           }
           
        }
        
        return (Integer)st.peek();
        
    }
}
