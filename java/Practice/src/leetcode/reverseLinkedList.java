/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class reverseLinkedList {
     public ListNode reverseBetween(ListNode head, int m, int n) {
         ListNode safeHead = new ListNode(0);
         safeHead.next = head;
         
        ListNode prev = safeHead;
        ListNode p = head;
        ListNode begin = prev;
        int count = 0;
        
        while(p != null && count < n){
            count++;
            
            if(count == m){
                begin = prev;
                prev = p;
                p = p.next;
                prev.next = null;
            }else if(count > m){
                ListNode tmp = p;
                p = p.next;
                tmp.next = prev;
                prev = tmp;
            }else{
                prev = p;
                p = p.next;
            }
            
           if(count == n){
                begin.next.next = p;
                begin.next = prev;
            }
        }
        
        if( count < n && count > m){
            begin.next = prev;
        }
        
        return safeHead.next;
    }
}
