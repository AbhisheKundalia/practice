/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class strStr {
     public String strStr(String haystack, String needle) {
         int index1 = 0;
         int index2 = 0;
         
         while(index1 < haystack.length() && index2 < needle.length()){
             if(haystack.charAt(index1) == needle.charAt(index2)){
                 index1++;
                 index2++;
             }else{
                 index1 = index1 -  index2 + 1;
                 index2 = 0;
             }
          }
         
         if(index2 == needle.length()) return haystack.substring(index1 - index2);
         
         return null;    
     }
}
