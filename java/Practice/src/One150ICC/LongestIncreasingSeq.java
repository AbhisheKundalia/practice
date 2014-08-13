/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package One150ICC;

/**
 *
 * @author admin
 */
public class LongestIncreasingSeq {
    public int LIS(int[] A){
        int[] nums = new int[A.length];
        int max = 1;
        
        for(int i = 0; i < A.length; i++)
            nums[i] = 1;
        
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < i; j++){
                if(A[i] > A[j] && nums[i] > nums[j] + 1)
                {
                    nums[i] = nums[j] + 1;
                    max = Math.max(max, nums[i]);
                }
            }
        }
        
        return max;
    }
}
