/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Stack;
import java.util.*;

/**
 *
 * @author admin
 */
public class postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root){
         Stack<TreeNode> nodes = new Stack<TreeNode>();
        List<Integer> results = new ArrayList<Integer>();
        TreeNode tmp = root;
        if(root == null){
            return results;
        }
        
        if(root.left != null){
            results.addAll(postorderTraversal(root.left));
        }
        
        if(root.right != null){
            results.addAll(postorderTraversal(root.right));
            
        }
        results.add(root.val);
        
        return results;
    }
    
     public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        List<Integer> results = new ArrayList<Integer>();
        TreeNode tmp = root;
        if(root == null){
            return results;
        }
        
        nodes.push(tmp);
        while( !nodes.empty() ){
            tmp = nodes.pop();
            results.add(0,tmp.val);
            
            if(tmp.left != null){
                nodes.push(tmp.left);
            }
            
            if(tmp.right != null){
              nodes.push(tmp.right);
            }
        }
                        
        return results;
    }
}
