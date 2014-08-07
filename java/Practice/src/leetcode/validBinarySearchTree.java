/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class validBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> tmp = new Stack<TreeNode> ();
        int prev = Integer.MIN_VALUE;
        TreeNode p = root;
        
        while(p != null || !tmp.isEmpty()){
            while(p != null){
                tmp.add(p);
                p = p.left;
            }
            
            if(!tmp.isEmpty()){
                p = tmp.pop();
                if(p.val <= prev) return false;
                prev = p.val;
                
                p = p.right;
            }
        }
        
        return true;
    }
}
