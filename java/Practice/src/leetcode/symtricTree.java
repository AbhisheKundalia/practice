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
public class symtricTree {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> left = new LinkedList<TreeNode>();
        Queue<TreeNode> right = new LinkedList<TreeNode>();
        
        if(root == null) return true;
        left.add(root.left);
        right.add(root.right);
        
        while(!left.isEmpty()){
            int size = left.size();
            
            for(int i = 0; i < size; i++){
                TreeNode leftp = left.poll();
                TreeNode rightp = right.poll();
                
                if(leftp != null && rightp != null && leftp.val == rightp.val ){
                    left.add(leftp.left);
                    left.add(leftp.right);
                    right.add(rightp.right);
                    right.add(rightp.left);
                    continue;
                }
                
                if(leftp == null && rightp == null) continue;
                
                return false;
            }
        }
        
        return true;
    }
}
