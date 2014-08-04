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
        int start = 0, end = A.length - 1;
      
      while(start <= end){
          int middle = (start + end)/2;
          
          if(A[middle] == target) return middle;
          
          if(A[middle] < target){
             if(A[start] > A[middle] && target > A[end]){
                 end = middle-1;
             }else{
                 start = middle + 1;
             }
          }else{           
              if(A[middle] > A[end] && target < A[start]){
                  start = middle + 1;
              }else{
                  end = middle - 1;
              }      
          }
      }
      
      return -1;
     }
     
     public boolean search2(int[] A, int target) {
        int start = 0, end = A.length - 1;
      
      while(start <= end){
          int middle = (start + end)/2;
          
          if(A[middle] == target) return true;
          
          if(A[start] == A[end]){
              start++;
              continue;
          } 
          
          if(A[middle] < target){
             if(A[start] > A[middle] && target > A[end]){
                 end = middle-1;
             }else{
                 start = middle + 1;
             }
          }else{
              
              if(A[middle] > A[end] && target < A[start]){
                  start = middle + 1;
              }else{
                  end = middle - 1;
              }
              
          }
      }
      
      return false;
    }
}
