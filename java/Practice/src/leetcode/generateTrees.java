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
public class generateTrees {
    public List<TreeNode> generateTrees(int n) {        
       return generateTreesFromRange(1, n);
    }
    
    public List<TreeNode> generateTreesFromRange(int s, int e){
          List<TreeNode> res = new ArrayList<TreeNode>();
          
          if(s > e) {
              res.add(null);
              return res;
          }
          
        for(int i = s; i <= e; i++){         
            List<TreeNode> left = new ArrayList<TreeNode>();
            List<TreeNode> right = new ArrayList<TreeNode>();
            
            left = generateTreesFromRange(s, i-1);
            right = generateTreesFromRange(i+1, e);
            
            for(int j = 0; j < left.size(); j++){
                for(int t = 0; t < right.size(); t++){
                    TreeNode newnode = new TreeNode(i);//we need to create a new node everytime
                    newnode.left = left.get(j);
                    newnode.right = right.get(t);
                    res.add(newnode);
                }
            }
        }
        
        return res;
      }
    
}
