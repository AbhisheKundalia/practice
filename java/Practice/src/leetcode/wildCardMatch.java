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
public class wildCardMatch {

    public boolean isMatch(String s, String p) {
        int s0 = 0;
        int p0 = 0;
        int pre_p = -1, pre_s = -1;
       
       while(s0 < s.length()){
           if(s0 < s.length() && p0 < p.length() && (s.charAt(s0) == p.charAt(p0) || p.charAt(p0) == '?')){
               s0++;
               p0++;
           }else if(p0 < p.length() && p.charAt(p0) == '*'){
               while(p0 < p.length() && p.charAt(p0) == '*') p0++;
               if(p0 == p.length()) return true;
               
               pre_p = p0;
               pre_s = s0;
           }else if(pre_p > -1){
               pre_s++;
               s0 = pre_s;
               p0 = pre_p;
           }else{
               return false;
           }    
       }
       
       while(p0 < p.length() && p.charAt(p0) == '*') p0++;
       
      return p0 == p.length();
    }
}
