/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class simplifyPath {
    public String simplifyPath(String path) {
        String result = "";
        path = "/" + path;
        
        int start = 0, end = 0;
        while(start < path.length()){
            end = start+1;
            
            while(end < path.length() && path.charAt(end) != '/'){
                end++;
            }
            
            if(path.substring(start, end).matches("\\/\\.{0,2}")){
                
                if(path.substring(start, end).equals("/..")){
                    int i = result.length() - 1;
                    
                    while(i >= 0 && result.charAt(i) != '/'){
                        i--;
                    }
                    
                    if(i >= 0) result = result.substring(0, i);
                }
            }else{
               result += path.substring(start, end);  
            }
            
            start = end;
        }
        
        if(result.isEmpty()) result += "/";
        
        return result;
        
    }
}
