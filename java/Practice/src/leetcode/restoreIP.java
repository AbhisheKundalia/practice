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
public class restoreIP {
     public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String> ();
        Queue<String> tmp = new LinkedList<String> ();
        int len = s.length();
        
        tmp.add("");
        
        for(int i = 0; i < 4; i++){
            int size = tmp.size();
            
            int j = 0;
            while(j < size){
                j++;
                String s0 = tmp.poll();
                
                int beginIndex = s0.length()-i;
                int aveLen = (len - beginIndex)/(4-i);
                
                if(aveLen < 1 || aveLen > 3) continue;
                
                if( i == 3 ){
                    String news = s.substring(beginIndex);
                    
                    if(news.equals("0")){
                        res.add(s0+news);
                    }
                    
                    if(s.charAt(beginIndex) != '0' && Integer.valueOf(news) <= 255){
                       res.add(s0+news);
                    }
                }
                        
                if(aveLen < 3){
                 
                    String newS1 = s0 + s.substring(beginIndex, beginIndex+1) + ".";
                    tmp.add(newS1);
                    
                    if( beginIndex+2 <= len && s.charAt(beginIndex) != '0'){
                      String newS2 = s0 + s.substring(beginIndex, beginIndex+2) + ".";
                      tmp.add(newS2);
                    }
                }
            
                if(beginIndex+3 <= len){
                    int ipAdd = Integer.valueOf(s.substring(beginIndex, beginIndex+3));
                    
                    if( ipAdd <= 255 && s.charAt(beginIndex) != '0'){
                        String newS3 = s0 + s.substring(beginIndex, beginIndex+3) + ".";
                        tmp.add(newS3);
                    }
                    
                }
            }    
        }
        
        
        return res;
    }
}
