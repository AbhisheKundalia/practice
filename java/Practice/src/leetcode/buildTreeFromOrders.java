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
public class buildTreeFromOrders {
    public TreeNode buildTree(int[] inorder, int[] preorder) {
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
       
        if(inorder.length != preorder.length || preorder.length == 0) return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        
        for(int i = 0; i < inorder.length; i++){
            index.put(inorder[i], i);
        }
        
        for(int j = 0; j < preorder.length; j++){
            TreeNode newNode = new TreeNode(preorder[j]);
            int pos = index.get(preorder[j]);
            
            TreeNode p = root;
            
            while(p != null){
                if(pos > index.get(p.val)){
                    if(p.right != null){
                        p = p.right;
                    }else{
                        p.right = newNode;
                        p = null;
                    }
                }else{
                    if(p.left != null){
                        p = p.left;
                    }else{
                        p.left = newNode;
                        p = null;
                    }
                }
            }
              
        }
        
        return root;
    }
    
    public TreeNode buildTree2(int[] inorder, int[] preorder) {
        
          if(inorder.length != preorder.length || preorder.length == 0) return null; 
           
          return buildSubTree(inorder, 0, inorder.length-1, preorder, 0, inorder.length-1);
        
    }
    
     public TreeNode buildSubTree(int[] inorder, int begin, int end, int[] preorder, int s, int t) {
        
           TreeNode root = new TreeNode(preorder[s]);
           int pos = begin;
           
           for(int i = begin; i <= end; i++){
               if(inorder[i] == preorder[s]){
                   pos = i;
                   break;
               }
           }
              
           if(begin <= pos - 1) root.left = buildSubTree(inorder, begin, pos-1, preorder, s+1, s+pos-begin);
           
           if(pos+1 <= end) root.right = buildSubTree(inorder, pos+1, end, preorder, s + pos-begin+1, t);
           
           return root;
        
    }
     
     public TreeNode buildTree3(int[] inorder, int[] postorder) {
        
          if(inorder.length != postorder.length || postorder.length == 0) return null; 
           
          return buildSubTree1(inorder, 0, inorder.length-1, postorder, 0, inorder.length-1);
        
    }
     
      public TreeNode buildSubTree1(int[] inorder, int begin, int end, int[] postorder, int s, int t) {
        
           TreeNode root = new TreeNode(postorder[t]);
           int pos = begin;
           
           for(int i = begin; i <= end; i++){
               if(inorder[i] == postorder[t]){
                   pos = i;
                   break;
               }
           }
              
           if(begin <= pos - 1) root.left = buildSubTree1(inorder, begin, pos-1, postorder, s, s+pos-begin-1);
           
           if(pos+1 <= end) root.right = buildSubTree1(inorder, pos+1, end, postorder, s + pos-begin, t-1);
           
           return root;
        
    }
     
}
