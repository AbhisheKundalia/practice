/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 * 
 * similar with plus one
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        String result = "";
        int alen = a.length();
        int blen = b.length();
        
        int len = Math.min(a.length(), b.length());
        
        int i = 1;
        int add = 0;
        
        while( i <= len){          
            result = String.valueOf(add^(a.charAt(alen-i) - '0')^(b.charAt(blen-i)) - '0') + result;
            add =  (add+(a.charAt(alen-i)-'0')+(b.charAt(blen-i) - '0'))/2;
            i++;
        }
        
        while(alen >= i){
            result = String.valueOf(add^(a.charAt(alen-i) - '0')) +result;
            add = add&(a.charAt(alen-i)-'0');
            if(add == 0) return a.substring(0, alen - i) + result;
            i++;
        }
        
        while(blen >= i){
            result = String.valueOf(add^(b.charAt(blen-i) - '0')) +result;
            add = add&(b.charAt(blen-i) - '0');
            if(add == 0) return b.substring(0, blen - i) + result;
            i++;
        }
        
        if(add > 0){
            result = add + result;
        }
        
        return result;
    }
    
    //updated on July-25   
     public String addBinary2(String a, String b) {
          String res = "";
          int aLen = a.length();
          int bLen = b.length();
          int add = 0, add1= 0, add2 = 0;
          
          int i = 1;
          
          while(i <= aLen || i <= bLen || add > 0){
       
             add1 = i <= aLen ? a.charAt(aLen - i) - '0' : 0;
             add2 = i <= bLen ? b.charAt(bLen - i) - '0' : 0;
              
             res = (add1+add2+add)%2 + res;
             add = (add1 + add2 + add)/2;
              i++;
          }
          
          return res;
    }
    
}
