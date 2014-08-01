/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class removeElement {
    public int removeElement(int[] A, int elem) {
        int num = 0;
        
        for(int i = 0; i < A.length; i++){
            if(A[i] == elem){
                num++;
                continue;
            }
            
            A[i-num] = A[i];
        }
        
        return A.length - num;
    }
}
