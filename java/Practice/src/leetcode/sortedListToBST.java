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
    public TreeNode sortedListToBST2(ListNode head) {
        if(head == null) return null;
        ListNode safehead = new ListNode(0);
        safehead.next = head;
        
        ListNode prev = safehead;
        ListNode p = head;
        
        //use two pointers, one increasing one step while the other increasing two steps  
        while( p != null && p.next != null){
            p = p.next.next;
            prev = prev.next;
        }
            
        TreeNode root = new TreeNode(prev.next.val);
        p = prev.next.next;
        prev.next = null;
        root.left = sortedListToBST(safehead.next);
        root.right = sortedListToBST(p);
            
        return root;
    }
    
     public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode p = head;
        
        while( p != null){
            n++;
            p = p.next;
        }
        
        return sortedsubListToBST(head, n);
    }
}
