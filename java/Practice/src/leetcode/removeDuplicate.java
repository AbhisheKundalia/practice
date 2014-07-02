/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class removeDuplicate {
    public int removeDuplicates(int[] A) {
        int moveStep = 0;
        
        for(int i = 1; i < A.length; i++){
            if(A[i] == A[i-1]){
                moveStep++;
            }
            A[i-moveStep] = A[i];
        }
        
        return A.length - moveStep;
    }
}
