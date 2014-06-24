/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

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
            }else if(top.right != null){
             top.right.val = value*10+top.right.val;
             tmp.push(top.right);
            }else{
                total += value;
            }    
          }
         
        }
        
        return total;
    }
}
