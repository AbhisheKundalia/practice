/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;
/**
 *
 * @author admin
 * 
 * For each node,we have four possibilities that maxPath contain the node:
 * 1. node only
 * 2. node + Left_sub
 * 3. node + right_sub
 * 4. Left_sub + node + right_sub
 * 
 */
public class binaryTreeMaxPathSum {
    public int maxPathSum(TreeNode root){
       int[] max = new int[1];
       max[0] = Integer.MIN_VALUE;
       maxSum(root, max);
       
       return max[0];
    }
    
    public int maxSum(TreeNode root, int[] max){
        int val = 0, left = 0, right = 0;
        
        val = root != null ? root.val : 0;   
        left = maxSum(root.left, max);
        right = maxSum(root.right, max);
        
        int currMax = val;
        
        if(left > 0) currMax += left;
        if(right > 0) currMax += right;
        max[0] = max[0] > currMax? max[0] : currMax;
        
        if(left > 0 && left >= right) return val + left;
        if(right > 0 && right > left) return val + right;
        
        return val;
    }
    
    
}
