/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package One150ICC;

/**
 *
 * @author admin
 */
public class convertBSTDLL {
    public TreeNode convertBSTtoDLL(TreeNode root){
        if(root == null) return root;
        TreeNode p = root;
        if(root.left != null){
            TreeNode left = convertBSTtoDLL(root.left);
            TreeNode prev = left.left;
            
            prev.right = root;
            root.left = prev;
            left.left = root;
            root.right = left;
            p = left;
        }
        
        if(root.right != null){
            TreeNode right = convertBSTtoDLL(root.right);
            TreeNode last = right.left;
            
            p.left = last;
            last.right = p;
            
            root.right = right;
            right.left = root; 
            
        }
        
        return p;
    }
}
