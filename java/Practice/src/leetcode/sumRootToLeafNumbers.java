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
public class sumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int total = 0;
        Stack<TreeNode> tmp = new Stack<TreeNode>();
        tmp.push(root);
        
        while(!tmp.empty()){
         TreeNode top = new TreeNode(0);
         top = tmp.pop();
         int value = 0;
         
         if(top != null){
            value = top.val;    
            
            if(top.left != null){
             top.left.val = value*10+top.left.val;
             tmp.push(top.left);
            }
            
            if(top.right != null){
             top.right.val = value*10+top.right.val;
             tmp.push(top.right);
            }
            
            if(top.right == null && top.left == null){
                total += value;  
            }
          }
         
        }
        
        return total;
    }
    
    //this problem is printing out all leves
     public int sumNumbers2(TreeNode root) {
         int total = 0;
         if(root == null) return total;
         
         Queue<TreeNode> tmp = new LinkedList<TreeNode>();
         Queue<Integer> num = new LinkedList<Integer>();
         tmp.add(root);
         num.add(root.val);
         
         while(!tmp.isEmpty()){
             int size = tmp.size();
             
             for(int i = 0; i < size; i++){
                 TreeNode p = tmp.poll();
                 int num0 = num.poll();
                 
                 if(p.left != null){
                     tmp.add(p.left);
                     num.add(num0*10 + p.left.val);
                 }
                 
                 if(p.right != null){
                     tmp.add(p.right);
                     num.add(num0*10 + p.right.val);
                 }
                 
                 if(p.right == null && p.left == null){
                     total += num0;
                 }
             }
         }
         
         return total;
    }
}
