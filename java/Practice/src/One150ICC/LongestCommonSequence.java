/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package One150ICC;

/**
 *
 * @author admin
 * 
 * f(i,j) = f(i-1, j-1) + 1 (si == sj)
 * f(i, j) = Max(f(i-1,j), f(i,j-1));
 */
public class LongestCommonSequence {
    public int longestCommonSequence(String s1, String s2){
        int row = s1.length();
        int col = s2.length();
        int start=0, end = 1;
        
        //reduce the size of the comparision - optimization
        while(start < row && start < col && s1.charAt(start) == s2.charAt(start)){
            start++;
        }
        
        while(end <= row && end <= col && s1.charAt(row-end) == s2.charAt(col - end)){
            end--;
        }
       
       int total = start + row - end;
        
       int[][] num = new int[row - total][col-total];
        for(int i = start; i < row - end; i++){
            for(int j = start; j < col - end; j++){
                if(i*j == 0 && s1.charAt(i + start) == s2.charAt(j + start)){
                    num[i][j] = 1;            
                }else if(i*j != 0){
                    if(s1.charAt(i + start) == s2.charAt(j + start)) num[i][j] = num[i-1][j-1];
                    else num[i][j] = Math.max(num[i-1][j], num[i][j-1]);
                }
            }
        }
        
        total += num[row - total - 1][col - total - 1];
        
        return total;
    }
}
