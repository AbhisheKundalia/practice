/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;

/**
 *
 * @author admin
 * 
 *  1. find the last node that less than the x
 *  2. use one point to iterate the linkedList
 *  3. add one dummy node to handle the last less node is null
 * 
 * 
 */
public class partition {
     public ListNode partition(ListNode head, int x) {
        ListNode safeHead = new ListNode(0);
        safeHead.next = head;
        ListNode prev = safeHead;
        ListNode p = prev;
        
        while(p.next != null && p.next.val < x){              
                p = p.next;
                prev = prev.next;
        }
        
        while(p.next != null){
            if(p.next.val < x){          
                ListNode tmp = p.next;
                p.next = p.next.next;
                tmp.next = prev.next;
                prev.next = tmp;
                prev = prev.next;
                
              }else{
                p = p.next;
             }
        }
        
        return safeHead.next;
    }
}
