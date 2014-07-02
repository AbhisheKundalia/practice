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
public class textJustification {
     public List<String> fullJustify(String[] words, int L) {
        int startIndex = 0, i = 0;
        int len = words.length;
        List<String> res = new ArrayList<String>();
        
        while(i < len){
            startIndex = i;
            String s = words[i];
            int currLen = words[i].length();
            int spaceNum = 0;
            int next = i+1;
            
            while(currLen <= L && next < len){
                 currLen += words[next].length() + 1;
                 next++;
            }
            
            if(L < currLen) {
                currLen -= (words[next-1].length()+1);
                next--;
            }
            
             next--;
            
            if( next ==  startIndex || next == len - 1) {
                
                if(next == len - 1){
                  for(int j = startIndex + 1; j <= next; j++)
                        s += " " + words[j];
                     }
                  
                spaceNum = L-currLen;
                for(int t = 0; t < spaceNum; t++){
                    s += " ";
                }
                
                res.add(s);
                
            }else{           
             spaceNum = 1 + (L - currLen)/(next - startIndex);
             
             for(int t = 0; t < next - startIndex; t++){
                 for(int k = 0; k < spaceNum; k++){
                    s+=" "; 
                 }
                 
                 if(t < (L - currLen)%(next - startIndex)){
                     s += " ";
                 }
                 
                 s+= words[startIndex + t + 1];
             }
             
             res.add(s);
            }
            
            i = next + 1;
        }
        
        return res;
    }
}
