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
        
        for(int i = 0; i < A.length - num; i++){
            if(A[i] == elem){
                while(num <= A.length - 1 && A[A.length - 1 - num] == elem) num++;
                
                if( i  <  A.length - 1 - num)
                {
                    A[i] = A[A.length - 1 - num];
                    num++;
                }
            }
        }
        
        return A.length - num;
    }
}
