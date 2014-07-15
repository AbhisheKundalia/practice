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
public class flatternBSTToLinkedList {
     public void flatten(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> tmp = new Stack<TreeNode>();
        
        while(p != null){           
         if(p.left != null || p.right != null){
            if(p.left != null){
                if(p.right != null){
                    tmp.push(p.right);
                }
                
                p.right = p.left;
                p.left = null;
            }
                
            }else if(!tmp.isEmpty()){
                TreeNode top = tmp.pop();
                p.right = top;   
            }
            
            p = p.right;
        }
    }
}
