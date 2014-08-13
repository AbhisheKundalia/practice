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
public class binaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> tmp = new Stack<TreeNode>();
        if(root == null) return res;
        
        TreeNode p = root;
        
        while(!tmp.isEmpty() || p != null){
            while(p!=null){
                tmp.add(p);
                p = p.left;
            }
            p = tmp.pop();
            res.add(p.val);
            p = p.right;
            
        }
       
        return res;
    }
    
    public List<Integer> PreorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> tmp = new Stack<TreeNode>();
        if(root == null) return res;
        
        TreeNode p = root;
        tmp.add(root);
        while(!tmp.isEmpty()){
            p = tmp.pop();
            res.add(p.val);
            
            if(p.right != null) tmp.add(p.right);
            if(p.left != null) tmp.add(p.left);   
        }
       
        return res;
    }
    
    public List<Integer> PostorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> tmp = new Stack<TreeNode>();
        if(root == null) return res;
        
        TreeNode p = root;
        
        while(!tmp.isEmpty() || p != null){
            while(p!=null){
                tmp.add(p);
                p = p.left;
            }
            p = tmp.pop();
            res.add(p.val);
            p = p.right;
            
        }
       
        return res;
    }
}
