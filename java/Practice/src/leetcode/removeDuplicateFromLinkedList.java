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
        ListNode begin = head;
        ListNode p = head;
        
        if(head == null) return head;
        
        while(p.next != null){
            if(p.next.val != p.val){
                if(p != begin){
                   begin.next = p.next;    
                }else{
                
                 begin = begin.next;
                }
                
                p = begin;
            }else{
                p = p.next;
            }
        }
        
        //need to consider the rest
        if(begin != p){
            begin.next = null;
        }
        
        return head;
        
    }
      public ListNode deleteDuplicates2(ListNode head) {
        ListNode safeHead = new ListNode(0);
        safeHead.next = head;
        ListNode p = head;
        ListNode begin = safeHead;
        
       if(head == null) return head;
        
        
        while(p.next != null){
            if(p.next.val != p.val){
                
                if(begin.next != p){
                    begin.next = p.next;
                }
                p = p.next;
                
            }else{
                p = p.next;
            }
        }
        if(begin.next != p){
            begin.next = null;
        }
        
        return safeHead.next;
    }
}
