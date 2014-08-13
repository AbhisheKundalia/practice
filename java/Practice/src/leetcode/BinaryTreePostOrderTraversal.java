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
 * find the leftmost node, for each step, push the right node and node into the stack
 * if node is null, pop up one node, check its right node is equal to the top node of the stack,
 * then pop up one node, store this node to stack, move to its right node
 * repeat this whole process
 */
public class BinaryTreePostOrderTraversal {
     public List<Integer> PostOrderTraversal(TreeNode root){
         List<Integer> res = new ArrayList<Integer>();
         Stack<TreeNode> tmp = new Stack<TreeNode>();
         TreeNode p = root;
         
         while(!tmp.isEmpty() || p != null ){
             while(p != null){
                 if(p.right != null) tmp.add(p.right);
                 tmp.add(p);
                 p = p.left;
             }
             
            p = tmp.pop();
            
            if(p.right != null && !tmp.isEmpty() && p.right == tmp.peek()){
               TreeNode tmp0 = tmp.pop();
               tmp.add(p);
               p = p.right;
            }else{
                res.add(p.val);
                p = null;
            }

         }
         
         return res;
     }
}
