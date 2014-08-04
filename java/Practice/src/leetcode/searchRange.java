/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class searchRange {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        
        result[0] = searchRange1(A, target, true);
        result[1] = searchRange1(A, target, false);
        
        return result;
    }
    
    //binary search for beginIndex and endIndex respectily 
     public int searchRange1(int[] A, int target, boolean first){
           int start = 0, end = A.length - 1;
           int index = -1;
           
           while(start <= end){
               int middle = (start + end)/2;
               
               if(A[middle] > target){
                   end = middle - 1;
               }
               
               if(A[middle] < target){
                   start = middle + 1;
               }
               
               if(A[middle] == target){
                   index = middle;
                   
                   if(first) end = middle-1;
                   else start = middle + 1;
               }
           }
          
           return index;
    }
}
