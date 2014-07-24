/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class lengthOfLongestNondescendingsequence {
    public int lengthofnondescendingseq(int[] A){
        int[] length = new int[A.length];
        int max = 0;
        
        for(int i = 0; i < A.length; i++){
            int j = i;
            int currMax = 1;
            
            while(--j >= 0){             
                if(A[j] < A[i])
                    currMax = Math.max(currMax, A[j]+1);
            }
            
           length[i] = currMax ;
            
            max = Math.max(length[i], max);
        }
        return max;
    }
}
