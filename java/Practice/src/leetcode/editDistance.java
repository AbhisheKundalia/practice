/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 * 
 * 
 * similar problem interleave string
 * 
 */
public class editDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        int[][] minDis = new int[len1+1][len2+1];
        
        for(int i = 0; i <= len1; i++){
            for(int j = 0; j <= len2; j++){
                if(i == 0){
                    minDis[i][j] = j;
                }else if( j == 0){
                    minDis[i][j] = i;
                }else{
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        minDis[i][j] = minDis[i-1][j-1]; 
                    }else{
                        int min = Math.min(minDis[i-1][j-1], minDis[i][j-1]);
                        min = Math.min(min, minDis[i-1][j]);
                        
                        minDis[i][j] = min + 1;
                    }
                }
            }
        }
        
        return minDis[len1][len2];
        
    }
}
