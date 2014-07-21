/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author admin
 * 
 * 
 */
public class test {
    public static void main(String[] args)  {
        // TODO code application logic here
        
        int[] A = new int[] {1,1};
        int[] B = new int[] {1,2};
        
         medianOfTwoArrays t = new medianOfTwoArrays();
          double res = t.findMedianSortedArrays(A, B);
         
         System.out.println(res);
    }
}
