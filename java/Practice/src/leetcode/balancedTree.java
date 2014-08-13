/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class balancedTree {
    public boolean isBalancedTree(TreeNode root){
        
        return getHeight(root) != -1;
    }
    
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        
        int leftheight = 0, rightheight = 0;
        
        if(root.left != null) leftheight = getHeight(root.left);
        if(root.right != null) rightheight = getHeight(root.right);
        
        if(leftheight == -1 || rightheight == -1 || Math.abs(leftheight - rightheight) > 1) return -1;
        
        int height = leftheight > rightheight? leftheight : rightheight;
        
        height++;
        return height;
    }
}
