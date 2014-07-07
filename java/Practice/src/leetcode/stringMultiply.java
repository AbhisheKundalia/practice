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
        int len1 = num1.length();
        int len2 = num2.length();
        
        for(int i = 0; i < len2; i++){
            char a = num2.charAt(len2 - 1 - i);
            
            String addNum = multiply0(num1, a);         
            result = add(result, addNum, i);
        }
        
        int j = 0;
        while( j < result.length() && result.charAt(j) == '0'){
           result = result.substring(1);
        }
        
        if(result.isEmpty()) result = "0";
        
        return result;
    }
    
    public String multiply0(String s1, char s2){
        String res = "";  
        int add = 0;
        int digit = s2 - '0';
        
        if(digit == 0) return "0";
        
        for(int j = s1.length() - 1 ; j >= 0 ; j--){
                int t = add + digit * (s1.charAt(j) - '0');
                res = String.valueOf(t%10) + res;
                add = t/10;
        }
            
        if(add > 0) res = add + res;
        
        return res;
    }
    
    public String add(String s1, String s2, int n){
        String total = "";
        int s1len = s1.length();
        int s2len = s2.length();
        
        int i = 1;
        int add = 0;
        
        if(s2.equals("0")) return s1;
        
        while(i <= s1len || i <= s2len + n){
            int add1 = 0, add2 = 0;
           
            if( i <= s1len){
                add1 = s1.charAt(s1len - i) - '0';
            }
            
            if( i <= s2len + n && i > n){
                add2 = s2.charAt(s2len + n - i) - '0';
            }
            
            total =  (add + add1 + add2) % 10 + total;
            add = (add + add1 + add2)/10;
            i++;
        }
        
        if(add > 0) total = add + total;
        
        return total;
    }
}
