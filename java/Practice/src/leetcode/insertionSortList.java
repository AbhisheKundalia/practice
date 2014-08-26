/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class insertionSortList {
     public ListNode insertionSortList(ListNode head) {
        ListNode safehead = new ListNode(0);
        
        ListNode p = head;
        ListNode prev = safehead;
        
        while(p != null){
            prev = safehead;
            while(prev.next != null && prev.next.val < p.val){
                prev = prev.next;
            }
            
            ListNode tmp = p;
            p = p.next;
            tmp.next = prev.next;
            prev.next = tmp;
        }
        
        return safehead.next;
    }
}
