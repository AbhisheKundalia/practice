package leetcode;


import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 * 
 * Inorder problem. we translate this problem into recoverSortedArray
 * 1. first changed element is greater than both side
 * 2. second switched element is less than both of side
 * 
 */
public class recoverTree {
    public void recoverTree(TreeNode root) {
        TreeNode firstnode = null, secondnode = null;
        Stack<TreeNode> tmp = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode t = root;
        
        while( t != null || !tmp.isEmpty() ){
            
            while(t != null && t.left != null){
                tmp.add(t);
                t = t.left;
            }
            
            if( t == null ) t = tmp.pop(); 
            
            if( prev != null && prev.val > t.val ){
                if(firstnode == null){
                    firstnode = prev;
                    secondnode = t;
                }else if(prev != null){// notice t not prev is the second element 
                    int val = firstnode.val;
                    firstnode.val = t.val;
                    t.val = val;
                    return;
                }
            }
            
             prev = t;
             t = t.right;  
        }
        
        if( firstnode != null){
        int val = firstnode.val;
        firstnode.val = secondnode.val;
        secondnode.val = val;
        }
        
    }
}
