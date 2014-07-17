/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if( p == null && q == null) return true;
        
        if( p != null && q != null && p.val == q.val){
            return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
        }
        
        return false;
    }
}
