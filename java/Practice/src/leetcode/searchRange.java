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
        if(A.length == 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        
        result[0] = searchRange1(A, 0, A.length-1, target, true);
        result[1] = searchRange1(A, 0, A.length-1, target, false);
        
        return result;
    }
    
    public int searchRange1(int[] A, int begin, int end, int target, boolean first){
           if (begin > end) return -1;
           int middle = (begin+end)/2;
           
           if(A[middle] > target){
              end = middle-1;   
           }else if(A[middle] < target ){
               begin = middle+1;
           }else if(A[middle] == target){
               if(first){
                   end = middle-1;
               }else{
                   begin = middle+1;
               }
           }
           
          int index = searchRange1(A, begin, end, target, first);
          if(A[middle] == target && index == -1) return middle;
          
           return index;
    }
    
}
