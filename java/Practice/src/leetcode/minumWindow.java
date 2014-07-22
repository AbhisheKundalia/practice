/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class minumWindow {
     public String minWindow(String S, String T) {
        int[] visitCount = new int[256];
        boolean[] exist = new boolean[256];
        String minWindow = "";
        int count = T.length();
        int minLen = -1;
        int start = -1;
        int pos = 0;
        
        if(T.length() > S.length() || S.isEmpty() || T.isEmpty()) return minWindow;
        
        for(int i = 0; i < count; i++){
            visitCount[T.charAt(i)]++;
            exist[T.charAt(i)] = true;
        }
        
        for(int i = 0; i < S.length(); i++){
            if(exist[S.charAt(i)]){
                char tmp = S.charAt(i);
                
                if(start == -1) start = i;
                
                if(visitCount[tmp] > 0){
                   count--;                  
                 }else if(visitCount[tmp] <= 0 && tmp == S.charAt(start)){
                   //move the start
                     visitCount[tmp]++;
                     start++;
                     
                     while(start < i && (visitCount[S.charAt(start)] < 0 || !exist[S.charAt(start)])){
                         if(visitCount[S.charAt(start)] < 0) visitCount[S.charAt(start)]++;
                        
                         start++;
                     }
                 }
               
                if(count == 0 && (minLen == -1 || minLen > i - start+1)) {              
                        pos = start;
                        minLen = i - start + 1;
                 }
                
               visitCount[S.charAt(i)]--;
            }
        }
        
        if(minLen > 0) minWindow = S.substring(pos, minLen + pos);
            
        
        return minWindow;
    }
}
