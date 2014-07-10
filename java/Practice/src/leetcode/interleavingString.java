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
public class interleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        Stack<String> prevIndex = new Stack<String>();
        
        if(s3.length() != s1.length() + s2.length()) return false;
        prevIndex.push("0,0,0");
        
        while(!prevIndex.isEmpty()){
            String[] indexs = prevIndex.pop().split(",");
            int index1 = Integer.valueOf(indexs[0]);
            int index2 = Integer.valueOf(indexs[1]);
            int index3 = Integer.valueOf(indexs[2]);
            
            if(index1 == s1.length() && index2 == s2.length() && index3 == s3.length())
                return true;
            

            while(index3 < s3.length()){
            
               if(index1 < s1.length() && index2 < s2.length() && s1.charAt(index1) == s3.charAt(index3) && s2.charAt(index2) == s3.charAt(index3)){
                  index1++;
                  index3++;    
                  String index = index1 + "," + index2 + "," + index3;
                  prevIndex.push(index);
                  index1--;
                  index2++;
                   
               }else if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)){
                    index1++;
                    index3++;
               }else if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)){
                    index2++;
                    index3++;
               }else{
                   break;
               } 
            
            }
        }
        
        return false;
    }
    
    
    public boolean isInterLeave(String s1, String s2, String s3){
        if(s3.length() != s1.length() + s2.length()) return false;
        
        int len1 = s1.length();
        int len2 = s2.length();
        
        boolean[][] res = new boolean [len1+1][len2+1];
        
        for(int i = 0; i <= len1; i++){
            for(int j = 0; j <= len2; j++){
                
                if(i ==  0 && j == 0){
                    res[i][j] = true;
                }else {
                    if( j > 0 && s2.charAt(j-1) == s3.charAt(i+j-1)){
                        res[i][j] = res[i][j] || res[i][j-1];
                    }
                    
                    if(i > 0 && s1.charAt(i-1) == s3.charAt(i+j-1)){
                        res[i][j] = res[i][j] || res[i-1][j];
                    }
                }   
            }
        }
        return res[len1][len2];
    }
}
