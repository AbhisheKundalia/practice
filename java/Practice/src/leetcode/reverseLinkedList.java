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

        while (p != null && count < n) {
            count++;

            if (count == m) {
                begin = prev;
                prev = p;
                p = p.next;
                prev.next = null;
            } else if (count > m) {
                ListNode tmp = p;
                p = p.next;
                tmp.next = prev;
                prev = tmp;
            } else {
                prev = p;
                p = p.next;
            }

            if (count == n) {
                begin.next.next = p;
                begin.next = prev;
            }
        }

        if (count < n && count > m) {
            begin.next = prev;
        }

        return safeHead.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode safehead = new ListNode(0);
        safehead.next = head;
        ListNode postK = safehead;
        int count = 0;
        ListNode p = safehead;

        while (p.next != null && count < k) {
            p = p.next;
            count++;
        }

        if(count < k || k < 2) return safehead.next;
        
        while (p != null) {
            ListNode tmp = postK;
            postK = postK.next;
            
            ListNode prev = postK;
            ListNode curr = postK.next;
      
            tmp.next = p;
            postK.next = p.next;
            p = p.next;

            count = k;
           
            while (curr != null && count > 1) {

                ListNode tmp0 = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp0;
                count--;

                if (p != null) {
                    p = p.next;
                }
            }
        }

        return safehead.next;
    }

  
}
