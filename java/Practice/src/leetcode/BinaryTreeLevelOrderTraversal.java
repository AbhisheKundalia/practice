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
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> tmp = new LinkedList<TreeNode>();
        if(root == null) return res;
        
        tmp.add(root);
        
        while(!tmp.isEmpty()){
            int size = tmp.size();
            List<Integer> level = new ArrayList<Integer>();
            
            for(int i = 0; i < size; i++){
                TreeNode node = tmp.poll();
                level.add(node.val);
                
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            
            res.add(level);
        }
        
        return res;
    }
    public List<List<Integer>> levelOrder2(TreeNode root) {
         List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> tmp = new LinkedList<TreeNode>();
        Stack<List<Integer>> res0 = new Stack<List<Integer>>();
        
        if(root == null) return res;
        
        tmp.add(root);
        
        while(!tmp.isEmpty()){
            int size = tmp.size();
            List<Integer> level = new ArrayList<Integer>();
            
            for(int i = 0; i < size; i++){
                TreeNode node = tmp.poll();
                level.add(node.val);
                
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            
            res0.add(level);
        }
        
        while(!res0.isEmpty()){
            res.add(res0.pop());
        }
        
        return res;
    }
}
