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
public class pathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        Queue<Integer> tmp = new LinkedList<Integer> ();
        Queue<TreeNode> tmp1 = new LinkedList<TreeNode> ();
        
        if(root == null) return false;
        
        tmp.add(root.val);
        tmp1.add(root);
        
        while(!tmp.isEmpty()){
           TreeNode top = tmp1.poll();
           int val = tmp.poll();
           
           if(top.left != null || top.right != null){
               
               if(top.left != null){
                   tmp.add(val+top.left.val);
                   tmp1.add(top.left);
               }
               
                if(top.right != null){
                   tmp.add(val+top.right.val);
                   tmp1.add(top.right);
               }
               
           }else{
               if(val == sum){
                   return true;
               }
           }
        }
        
        return false;
    }
    
    public List<List<Integer>> hasPathSum2(TreeNode root, int sum) {
        Queue<Integer> tmp = new LinkedList<Integer> ();
        Queue<TreeNode> tmp1 = new LinkedList<TreeNode> ();
        Queue<List<Integer>> path = new LinkedList<List<Integer>>();
        List<List<Integer>>  res = new ArrayList<List<Integer>>();
        List<Integer> tmp0 = new ArrayList<Integer>();
        
        if(root == null) return res;
        tmp0.add(root.val);
        path.add(tmp0);
        
        tmp.add(root.val);
        tmp1.add(root);
        
        while(!tmp.isEmpty()){
           TreeNode top = tmp1.poll();
           int val = tmp.poll();
           List<Integer> path0 = path.poll();
           
           if(top.left != null || top.right != null){
               
               if(top.left != null){
                   tmp.add(val+top.left.val);
                   tmp1.add(top.left);
                   List<Integer> path1 = new ArrayList<Integer> (path0);
                   path1.add(top.left.val);
                   path.add(path1);
               }
               
                if(top.right != null){
                   tmp.add(val+top.right.val);
                   tmp1.add(top.right);
                   List<Integer> path1 = new ArrayList<Integer> (path0);
                   path1.add(top.right.val);
                   path.add(path1);
               }
               
           }else{
               if(val == sum){
                   res.add(path0);
               }
           }
        }
        
        return res;
    }
}
