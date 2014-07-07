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
        
         String S = "fooowingmonkeypoundcake";
         String[] L = {"fooo","barr","wing","ding","wing"};
        
         int n = 3;
         
         stringMultiply sm = new stringMultiply();
         String add = sm.multiply("123", "456");
         System.out.println(add);
    }
}
