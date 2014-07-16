/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        int add = 0;
        
        while( p1 != null || p2 != null || add != 0){
            int num1 = 0, num2 = 0;
            
            if( add == 0 && !(p1 != null && p2 != null)){
              if(p1 != null) p.next = p1;
              if(p2 != null) p.next = p2;
              
              break;
            }
            
            if( p1 != null) {
                num1 = p1.val;
                p1 = p1.next;
            }
            if( p2 != null) {
                num2 = p2.val;
                p2 = p2.next;
            }
            
                      
            ListNode node = new ListNode((num1+num2+add)%10);
            add = (num1+num2+add)/10;
            p.next = node;
            p = p.next;
        }
        
        return head.next;
    }
}
