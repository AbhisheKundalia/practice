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
public class mergeSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null) {
            int p1val = p1.val;
            int p2val = p2.val;

            if (p1val <= p2val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            }

            if (p1val >= p2val) {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }

        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }

        return head.next;
    }

    public ListNode mergeKLists(List<ListNode> lists) {

        if(lists.size() < 1) return null;
        
        while (lists.size() > 1) {
            List<ListNode> tmp = new ArrayList<ListNode>();
            int i = 0;
            while (i < lists.size()) {
                if (i + 1 < lists.size()) {
                    ListNode res = new ListNode(0);
                    res.next = mergeTwoLists(lists.get(i), lists.get(i + 1));
                    tmp.add(res.next);
                } else {
                    tmp.add(lists.get(i));
                }
                i += 2; 
            }
            
            lists.clear();
            lists.addAll(tmp);
        }

        return lists.get(0);
    }
    
      public ListNode mergeKLists2(List<ListNode> lists) {
          
      }
}
