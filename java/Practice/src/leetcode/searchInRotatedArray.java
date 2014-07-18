/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class searchInRotatedArray {
     public int search(int[] A, int target) {
        if(A.length < 1) return -1;
        
        return search1(A, 0, A.length - 1, target);
    }
     
     public int search1(int[] A, int begin, int end, int target){
         if(begin > end) return -1;
         
         int middle = (begin + end)/2;
         
         if( A[middle] == target) return middle;
         
         if(A[middle] > target){
             if( A[begin] <= A[middle] && target < A[begin]){
                return search1(A, middle + 1, end, target);
             }else{
                return search1(A, begin, middle - 1, target);
             }
         }else{
             if( A[middle] <= A[end]  && target > A[end]){
                return search1(A, begin, middle - 1, target);
             }else{
                return search1(A, middle + 1, end, target);
             }
         }
     }
     public boolean searchwithDuplicate(int[] A, int begin, int end, int target) {
         if(begin > end) return false;
         
         while(begin < end && A[begin] == A[end]){
             begin++;
         }
         
         int middle = (begin + end)/2;
         
         if( A[middle] == target) return true;
         
         if(A[middle] > target){
             if( A[begin] <= A[middle] && target < A[begin]){
                return searchwithDuplicate(A, middle + 1, end, target);
             }else{
                return searchwithDuplicate(A, begin, middle - 1, target);
             }
         }else{
             if( A[middle] <= A[end]  && target > A[end]){
                return searchwithDuplicate(A, begin, middle - 1, target);
             }else{
                return searchwithDuplicate(A, middle + 1, end, target);
             }
         }
    }
}
