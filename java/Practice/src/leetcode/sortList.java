/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 *
 *
 *
 */
public class sortList {
    //bubble sort - complexity is n*n

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pnode = head;
        ListNode currentNode = head.next;
        ListNode prevNode = head;

        while (pnode.next != null && pnode.next.val <= currentNode.val) {
            pnode = pnode.next;
        }

        if (pnode.next != null) {
            head.next = currentNode.next;
            currentNode.next = pnode.next;
            pnode.next = currentNode;
            prevNode = pnode;
        }

        while (pnode.next != null) {
            if (pnode.next.val < currentNode.val) {
                prevNode.next = pnode.next;
                prevNode = prevNode.next;
                prevNode.next = currentNode;
                pnode.next = pnode.next.next;
            }
            pnode = pnode.next;
        }
        prevNode.next = null;

        sortList(head);
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = currentNode;

        if (head.next == null) {
            head.next = currentNode;
        }

        ListNode head0 = new ListNode(0);
        head0.next = currentNode.next;
        sortList(head0);

        currentNode.next = head0.next;

        return head;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode safehead = new ListNode(0);
        safehead.next = head;
        ListNode prev = safehead;
        ListNode pivot = head;
        ListNode p = head;

        while (p.next != null) {
            if (p.next.val <= pivot.val) {
                ListNode tmp = p.next;
                p.next = p.next.next;
                tmp.next = prev.next;
                prev.next = tmp;
                prev = prev.next;
            } else {
                p = p.next;
            }
        }

        if (prev != safehead) {
            prev.next = null;
            ListNode newHead = sortList2(safehead.next);
            ListNode tmp = newHead;

            while (tmp.next != null) {// iterate the list
                tmp = tmp.next;
            }

            tmp.next = pivot;
            safehead.next = newHead;
        }

        ListNode head2 = sortList2(pivot.next);
        pivot.next = head2;

        return safehead.next;
    }

    public ListNode sortList3(ListNode head) {
        int len = 0;
        ListNode p = head;
        
        while( p != null){
            p = p.next;
            len++;
        }
        
        return sort(head, len);  
    }
    
    public ListNode sort(ListNode head, int len){
        
        if(len <= 1) return head;
        
        ListNode safehead = new ListNode(0);
        safehead.next = head;
        ListNode p = safehead;
        int i = 0;
        
        while(i < len/2){
            p = p.next;
            i++;
        }
        
        ListNode nextp = p.next;
        p.next = null;
        
        ListNode head0 = sort(safehead.next, len/2);
        ListNode head1 = sort(nextp, len - len/2);
        ListNode newhead = mergeTwoLists(head0, head1);
        
        return newhead;
    }
    
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
}
