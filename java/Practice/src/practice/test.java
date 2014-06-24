/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

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
        
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        
        root.left = left;
        root.right = right;
        
        sumRootToLeafNumbers sum = new sumRootToLeafNumbers();
        
        int total = sum.sumNumbers(root);
        System.out.println();
    }
}
