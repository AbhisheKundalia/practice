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
public class removeDuplicateFromLinkedList {
     public ListNode deleteDuplicates(ListNode head) {
         if(head == null) return head;
        
         ListNode prev = head;
         ListNode p = prev.next;
         
        while(p != null){
            if(p.val != prev.val){
                prev = p;
                p = p.next;
            }else{
                p = p.next;
                prev.next = p;
            }
        }
        
        return head;
    }
     
      public ListNode deleteDuplicates2(ListNode head) {
         if(head == null) return head;
        
         ListNode safeHead = new ListNode(0);
         safeHead.next = head;
         ListNode prev0 = safeHead;
         
         ListNode prev = head;
         ListNode p = prev.next;
         
        while(p != null){
            if(p.val != prev.val){
                if(prev0.next != prev){
                    prev0.next = p;
                }else{
                    prev0 = prev;
                }
                
                prev = p;
                p = p.next;
            }else{
                prev = p;
                p = p.next;
            }
        }
        
        if(prev0.next != prev){
            prev0.next = prev.next;
        }
        
        return safeHead.next;
    }
}
