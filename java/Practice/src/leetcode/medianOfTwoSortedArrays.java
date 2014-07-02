/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class medianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int aLen = A.length;
        int bLen = B.length;
        int a = 0, b = 0;
        
        int index0 = (aLen + bLen)/2;
        int index1 = index0;
        if((aLen + bLen)%2 == 0) index1 = index0 - 1;
        
        int i = 0;
        int ta = 0;
        int tb = 0;
        
        while(i < aLen + bLen){
           
        }
        
        return (a+b)/2;
    }
}
