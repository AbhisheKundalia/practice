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
 */
public class test {
    public static void main(String[] args)  {
        // TODO code application logic here
        /*palindrome pa = new palindrome();
        List<List<String>> result = palindrome.partition("cbb");
        System.out.println(result.toString());*/
         String S = "fooowingmonkeypoundcake";
         String[] L = {"fooo","barr","wing","ding","wing"};
        // String s = "1";
         int n = 3;
         
         findSubString fs = new findSubString();
         List<Integer> re = fs.findSubstring(S, L);
         System.out.println(re.toString());
        // System.out.println(s.matches("\\s*[+-]?\\d+.*"));
       
       /* TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        
        int t = Integer.MIN_VALUE;
        System.out.println(t);
        t = t*(-1);
        System.out.println(t);
        
        Set<String> tmp = new HashSet<String>();
        tmp.add("a");
        tmp.add("b");
        tmp.add("c");
        
        String start = "a";
        String end = "c";
        
        wordLadder wordladder = new wordLadder();
        
        //int t= wordladder.ladderLength3(start, end, tmp);
       /* root.left = left;
        root.right = right;
        
        sumRootToLeafNumbers sum = new sumRootToLeafNumbers();
        
        int total = sum.sumNumbers(root);*/
        //System.out.println(t);
    }
}
