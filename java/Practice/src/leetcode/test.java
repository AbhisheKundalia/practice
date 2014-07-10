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
         String s1 = "aabc";
         String s2 = "abad";
         String s3 = "aabadabc";
         
         restoreIP restore = new restoreIP();
         
         
         System.out.println(restore.restoreIpAddresses("010010"));
    }
}
