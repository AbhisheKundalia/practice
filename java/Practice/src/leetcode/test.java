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
          Set<String> set = new HashSet<String>();
          
         set.add("ted");
         set.add("tex");
         set.add("red");
         set.add("tax");
         set.add("tad");
         set.add("den");
         set.add("rex");
         set.add("pee");
         
         wordLadder wd = new wordLadder();
         wd.findLadders("red","tax",set);
         
         System.out.println();
    }
}
