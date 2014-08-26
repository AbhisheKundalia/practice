/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class longestSubstring {
    public int lengthOfLongestSubstring(String s) {
           int startIndex = 0;
           boolean[] visited = new boolean[256];
           int maxLen = 0;
           
           for(int i = 0; startIndex <= i && i < s.length(); i++){
               char a = s.charAt(i);
               if(!visited[a]) {
                   visited[a] = true;
               }else{
                   maxLen = maxLen > (i-startIndex)? maxLen : i - startIndex;
                   while(s.charAt(startIndex) != a ) {
                        visited[s.charAt(startIndex)] = false;
                        startIndex++;       
                   }
                   startIndex++;
               }   
           }
           
           maxLen = maxLen > s.length() - startIndex? maxLen : s.length() - startIndex;
           
           return maxLen;
    }
    
    public int lengthOfLongestSubstring2(String s) {
         int startIndex = 0;
         int[] visited = new int[256];
         int maxLen = 0;
           
           for(int i = 0; i < 256; i++) visited[i] = -1;
           
           for(int i = 0; i < s.length(); i++){
               char a = s.charAt(i);
               if(visited[a] >= startIndex) {
                   maxLen = maxLen > (i - startIndex)? maxLen : i - startIndex;
                   startIndex = visited[a] + 1;
               }
               
               visited[a] = i;
           }
           
           maxLen = maxLen > s.length() - startIndex? maxLen : s.length() - startIndex;
           
           return maxLen;
    }
}
