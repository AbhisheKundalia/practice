/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class mergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        
        int t = 1;
        int i = m-1;
        int j = n-1;
        
        while(i >= 0 && j>=0){
            if(A[i] > A[j]){
                A[m+n-t] = A[i];
                i--;
            }else{
                A[m+n-t] = B[j];
                j--;
            }
            
            t++;
        }
        
        while(j>=0){
            A[m+n-t] = B[j];
            t++;
            j--;
        }
    }
}
