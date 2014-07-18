/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class sortedListToBST {
     public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode p = head;
        
        while( p != null){
            n++;
            p = p.next;
        }
        
        return sortedsubListToBST(head, n);
    }
     
     public TreeNode sortedsubListToBST(ListNode head, int n){
            if( n < 1 || head == null) return null;
            
            int pos = n/2;
            int i = 0;
            ListNode p = head;
            
            while( p.next != null && i < pos){
                p = p.next;
                i++;
            }
            
            TreeNode root = new TreeNode(p.val);
            
            root.left = sortedsubListToBST(head, n/2);
            root.right = sortedsubListToBST(p.next, n - n/2 - 1);
            
            return root;
     }
     
      public TreeNode sortedArrayToBST(int[] num) {
        return sortedSubArrayToBST(num, 0, num.length-1);
    }
      
      public TreeNode sortedSubArrayToBST(int[] num, int begin, int end){
          if( begin > end) return null;
          int middle = (begin+end)/2;
          
          TreeNode root = new TreeNode(num[middle]);
          
          root.left = sortedSubArrayToBST(num, begin, middle-1);
          root.right = sortedSubArrayToBST(num, middle+1, end);
          
          return root;
      }
}
