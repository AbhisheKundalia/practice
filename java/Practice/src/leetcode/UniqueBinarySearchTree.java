/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;
/**
 *
 * @author admin
 */
public class UniqueBinarySearchTree {
     public int numTrees(int n) {
        int total = 0;
        
        if(n < 2) return 1;
        
        for(int i = 0; i < n; i++){
            total += numTrees(i)*numTrees(n-1-i);
        }
        
        return total;
    }
     
      public List<TreeNode> generateTrees(int n) {
             return generateTrees1(1, n);
      }
      
      public List<TreeNode> generateTrees1(int start, int end){
             List<TreeNode> res = new ArrayList<TreeNode>();
             
             if(start < end) res.add(null);
             
             for(int i = start; i <= end; i++){
                 List<TreeNode> left = generateTrees1(start, i-1);
                 List<TreeNode> right = generateTrees1(i+1, end);
                 
                 for(int j = 0; j < left.size(); j++){
                     for(int k = 0; k < right.size(); k++){
                         TreeNode newNode = new TreeNode(i);
                         newNode.left = left.get(j);
                         newNode.right = right.get(k);
                         res.add(newNode);
                     }
                 }
             }
             
             return res;
      }
}
