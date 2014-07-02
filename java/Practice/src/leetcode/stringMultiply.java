/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 * 
 * similar with
 * 1. plus one
 * 2. add two binary 
 */
public class stringMultiply {
    public String multiply(String num1, String num2) {
        String result = "";
        String tmp = "";
        int num2len = num2.length();
        int num1len = num1.length();
        
        for(int i = num2len - 1; i >= 0; i--){
            int add = 0;
            int s1 = num2.charAt(i) - '0';
            
            for(int j = num1len -1 ; j >=0 ; j--){
                int t = add+s1*(num1.charAt(j));
                tmp = String.valueOf(t%10) + tmp;
                add = t/10;
            }
            
            result = add(result.substring(0, i), tmp) + result.substring(i);
        }
        
        return result;
    }
    
    public String add(String s1, String s2){
        String total = "";
        int s1len = s1.length();
        int s2len = s2.length();
        
        int i = 1;
        int add = 0;
        
        while(i < s1len || i < s2len){
            int add1 = 0, add2 = 0;
           
            if( i <= s1len){
                add1 = s1.charAt(s1len - i) - '0';
            }
            
            if( i <= s2len){
                add2 = s2.charAt(s2len - i) - '0';
            }
            
            total =  (add + add1 + add2) % 10 + total;
            add = (add + add1 + add2)/10;
            i++;
        }
        
        if(add > 0) total = add + total;
        
        return total;
    }
}
