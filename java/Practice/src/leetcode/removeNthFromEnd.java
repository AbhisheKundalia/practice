/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        
        int count = 0;
        ListNode safehead = new ListNode(0);
        safehead.next = head;
        ListNode p = safehead;
        ListNode postn = safehead;
        
        while(p.next != null){
              p = p.next;
              
              count++;
              
              if(count > n){
                  postn = postn.next;
              }
        }
        
        postn.next = postn.next.next;
        
       return safehead.next;
    }
}
