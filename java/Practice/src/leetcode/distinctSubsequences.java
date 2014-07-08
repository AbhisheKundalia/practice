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
public class distinctSubsequences {
     public int numDistinct(String S, String T) {
        int num = 1;
        int sameTotal = 1;
        int delNum = 0;
        int t = 0;
        
        for(int i = 0; i < S.length(); i++){
            if( i > 0 && S.charAt(i) == S.charAt(i-1)){
                sameTotal++;
            }else{
                num *= getNum(sameTotal, delNum); 
                sameTotal = 1;
                delNum = 0;
            }
            
            if( t >= T.length() || (t < T.length() && S.charAt(i) != T.charAt(t))){
                delNum++;
            }else{
                t++;
            }
        }
        
        if(t < T.length() - 1) return 0;
        
        if(delNum > 0) num *= getNum(sameTotal, delNum);
        
        return num;
    }
     
     public int getNum(int total, int delete){
         int res = 1;
         int a = 1;
         int b = 1;
         
         if(delete > total/2) delete = total - delete;
         
         for(int i = 0; i < delete; i++){
             a = a*(total - i);
             b = b*(i+1); 
         }
         
         return a/b;
     }
     
     public int numdistinct1(String S, String T){
         if(T.isEmpty()) return 1;         
         if(S.length() < T.length()) return 0;
         
         Stack<Integer> sIndex = new Stack<Integer>();
         Stack<Integer> tIndex = new Stack<Integer>();
         
         int num = 0;
         
         int sstart = 0;
         int tstart = 0;
         
         while(sstart < S.length() && tstart < T.length()){
             
         }
         
         
         
       return num;
     }
     
     public int numDistinct0(String S, String T){
         int row = S.length();
         int col = T.length();
         
         int[][] num = new int[row+1][col+1];
         
         for(int i = 0; i <= row; i++){
             for(int j = 0; j <= col; j++){
                 if(j == 0) {
                     num[i][j] = 1;
                 }else if( i == 0){
                     num[i][j] = 0;
                 }else{
                     if(S.charAt(i - 1) != T.charAt(j - 1)){
                         num[i][j] = num[i-1][j];
                     }else{
                         num[i][j] = num[i-1][j-1] + num[i-1][j];
                     }
                 }
             }
         }
         
         return num[row][col];
     }
}
