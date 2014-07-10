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
        int matches = T.length();
        int minLen = 0;
        int start = 0;
        
        if(T.length() > S.length() || S.isEmpty() || T.isEmpty()) return minWindow;
        
        for(int i = 0; i < matches; i++){
            visitCount[T.charAt(i)]++;
            exist[T.charAt(i)] = true;
        }
        
        for(int i = 0; i < S.length(); i++){
            if(exist[S.charAt(i)]){
                if(visitCount[S.charAt(i)] > 0){
                    if(matches == T.length()){
                        start = i;
                    }
                    
                    matches--;
                }else{
                    if(S.charAt(i) == S.charAt(start)){
                        start++;
                        while( start < i ){                          
                            if(exist[S.charAt(start)] && (visitCount[S.charAt(start)] < 0)){
                                visitCount[S.charAt(i)]++;
                                start++;
                            }else if(!exist[S.charAt(start)]){
                                start++;
                            }else{
                                break;
                            }
                        }
                        
                        if(matches == 0 && minLen > (i - start+1)){
                            minWindow = S.substring(start, i+1);
                            minLen = i - start + 1;
                        }
                    }     
                }
                
                if(matches == 0){
                     minWindow = S.substring(start, i+1);
                     minLen = i - start + 1;
                }
                
                visitCount[S.charAt(i)]--;
            }
        }
            
        
        return minWindow;
    }
}
