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
        
        prevIndex.push("0,0,0");
        
        while(!prevIndex.isEmpty()){
            String[] indexs = prevIndex.pop().split(",");
            int index1 = Integer.valueOf(indexs[0]);
            int index2 = Integer.valueOf(indexs[1]);
            int index3 = Integer.valueOf(indexs[2]);
            
            if(index1 == s1.length() && index2 == s2.length() && index3 == s3.length())
                return true;
            

            if(index1 < s1.length() && index3 < s3.length()){
                if(s1.charAt(index1) == s3.charAt(index3)){
                    index1++;
                    index3++;
                    String index = index1 + "," + index2 + "," + index3;
                    prevIndex.push(index);
                    index1--;
                    index3--;
                }
            }
            
            if(index2 < s2.length() && index3 < s3.length()){
                if(s2.charAt(index2) == s3.charAt(index3)){
                    index2++;
                    index3++;
                    String index = index1 + "," + index2 + "," + index3;
                    prevIndex.push(index);
                    
                    index2--;
                    index3--;
                }
            }     
        }
        
        return false;
    }
}
