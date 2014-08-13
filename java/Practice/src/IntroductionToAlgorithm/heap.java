/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IntroductionToAlgorithm;

/**
 *
 * @author admin
 */
public class heap {
    public void maxheapify(int[] A, int i){
        if(i > A.length/2) return;
        
        while(i <= A.length/2){
            int left = A[2*i+1];
            int right = A[2*i+2];
            
            if(A[i] > left && A[i] > right) return;
            
            int tmp = A[i];
            if(left >= right){          
                A[i] = A[2*i+1];
                A[2*i+1] = tmp;
                i = 2*i + 1;
            }else{
                A[i] = A[2*i+2];
                A[2*i+2] = tmp;
                i = 2*i + 2;
            }
        }
        
    }
}
