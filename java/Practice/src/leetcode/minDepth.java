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
public class minDepth {
    public int minDepth(TreeNode root) {   
        Queue<TreeNode> tmp = new LinkedList<TreeNode> ();      
        if(root == null) return 0;   
        
        tmp.add(root);
        int minDepth = 0;
        
        while(!tmp.isEmpty()){
            int count = tmp.size();
            minDepth++;
            
            for(int i = 0; i < count; i++){
               TreeNode t = tmp.poll();
               
               if(t.left == null && t.right == null){
                   return minDepth;
               }else{
                   if(t.left != null) tmp.add(t.left);
                   if(t.right != null) tmp.add(t.right);           
               }
            }
            
        }
        return minDepth;     
    }
}
