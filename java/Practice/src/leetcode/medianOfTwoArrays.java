/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 * 
 * this problem is same with finding the kth number in two sorted arrays 
 */
public class medianOfTwoArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int aLen = A.length, bLen = B.length;
        int middle = (aLen + bLen)/2;
        
        if((aLen+bLen)%2 != 0){
            return findkthNum(A, 0, aLen-1, B, 0, bLen-1, middle);    
        }else{
            return (findkthNum(A, 0, aLen-1, B, 0, bLen-1, middle) + findkthNum(A, 0, aLen-1, B, 0, bLen-1, middle-1))*0.5;
        }
         
    }
    
    public double findkthNum(int[] A, int begin1, int end1, int[] B, int begin2, int end2, int middle){
        int aLen = A.length; 
        int bLen = B.length;
        
        if(aLen == 0 || begin1 > end1){
            return B[begin2 + middle];
        }
        
        if(bLen == 0 || begin2 > end2){
            return A[begin1 + middle];
        }
            
        int m1 = (begin1 + end1)/2;
        int m2 =  (begin2 + end2)/2;
               
        if(A[m1] >= B[m2]){
          
           if((m1-begin1)+(m2-begin2)+1 == middle && ( m2 == end2 || B[m2+1] >= A[m1])){
               return A[m1];
           }else if(m1+m2+1 >= middle + begin1 + begin2){
               return findkthNum(A, begin1, m1-1, B, begin2, end2, middle);
           }else{ 
               middle = middle - (m2-begin2-1);
               return findkthNum(A, begin1, end1, B, m2+1, end2, middle);
           } 
                    
        }else{
            if (m1+m2+1 == middle + begin1 + begin2 && (m1 == end1 || B[m2] <= A[m1+1])){
                return B[m2];
            }else if(m1+m2+1 >= middle + begin1 + begin2){
                return findkthNum(A, begin1, end1, B, begin2, m2-1, middle);
            }else{
                middle = middle - (m1 -begin1 +1);
                return findkthNum(A, m1+1, end1, B, begin2, end2, middle);
            }
            
        }
    }
        
        public double findkthNum2(int[] A, int begin1, int end1, int[] B, int begin2, int end2, int k){
        int aLen = end1 - begin1 + 1; 
        int bLen = end2 - begin2 + 1;
        
        if(aLen == 0 || begin1 > end1){
            return B[begin2 + k];
        }
        
        if(bLen == 0 || begin2 > end2){
            return A[begin1 + k];
        }
        
        if(k == 0) return Math.min(A[begin1], B[begin2]);
        
        int m1 = begin1 + aLen*k/(aLen+bLen);
        int m2 =  k - (m1 - begin1 + 1) + begin2;
               
        if(A[m1] > B[m2]){
             end1 = m1;
             begin2 = m2+1;
             k = k - (m2 - begin2 +1); 
        }else{
            k = k - (m1 - begin1 + 1);
            begin1 = m1 + 1;
            end2 = m2;
        }
        
        return findkthNum2(A, begin1, end1, B, begin2, end2, k);
    }
}
