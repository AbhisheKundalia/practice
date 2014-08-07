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
       List<String> res = new ArrayList<String>();
        if(words.length < 1 || words[0].length() > L) return res;
        
        int start = 0;
        int num = 0;
        
        for(int i = 0; i < words.length; i++){
            if( (num + words[i].length() + (i-start) > L)){
                String str = "";
                
                for(int j = start; j < i-1; j++){
                    str += words[j];
                    
                    int spaceNum = (L - num)/(i-start-1);
                    
                    int t = 0;
                    while(t < spaceNum){
                        str += " ";
                        t++;
                    }
                    
                    if(j < (L-num)%(i-start-1) + start){
                        str += " ";
                    }
                }
                
                str += words[i-1];
                  
                while(str.length() < L) str += " ";
                res.add(str);
                start = i;
                num = words[i].length();
            }else{
                num += words[i].length();
            }
        }
    
        //the last piece
        String str = words[start];
        for(int j = start + 1; j < words.length; j++){
             str += " " + words[j];
        }
        
        while(str.length() < L) str += " ";
        res.add(str);
        
        return res;
    }
}
