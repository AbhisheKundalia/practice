/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class firstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            while(A[i] != i + 1 && A[i] > 0 && A[i] < A.length && A[i] != A[A[i]]){
                int t = A[i];

                A[i] = A[i]^A[t];
                A[t] = A[i]^A[t];
                A[i] = A[i]^A[t];
            }
            
            if(A[i] != i && i > 0) return i;
            
            i++;
        }
         
        if(i > 0) return i;
        
        return 1;
    }
    
    public void swap(int a, int b){
        int c = a;
        a = b;
        b = c;
    }
    
     public void swap2(int a, int b){
        a = a^b;
        b = a^b;
        a = a^b;
    }
    
}
