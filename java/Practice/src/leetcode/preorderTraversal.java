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
public class preorderTraversal {
      public List<Integer> preorderTraversal1(TreeNode root) {        
          List<Integer> results = new ArrayList<Integer>();
          
          if (root == null){
              return results;
          }
          
          results.add(root.val);
          
          if(root.left != null){
              results.addAll(preorderTraversal1(root.left));
          }
          
          if(root.right != null){
              results.addAll(preorderTraversal1(root.right));
          }
          
          return results;
          
    }
        public List<Integer> preorderTraversal2(TreeNode root) {
              List<Integer> results = new ArrayList<Integer>();
              Stack<TreeNode> nodes = new Stack<TreeNode>();
          
              if (root == null){
                  return results;
              }
              
              nodes.push(root);
              
              while(!nodes.empty()){
                  root = nodes.pop();
                  results.add(root.val);
                  
                  if(root.right != null){
                      nodes.push(root.right);
                  }
                  
                  if(root.left != null){
                      nodes.push(root.left);
                  }
              }
              
              return results;
    }
}
