/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author admin
 */
public class sortList {
    public ListNode sortList(ListNode head){
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode pnode = head;
        ListNode currentNode = head.next;
        ListNode prevNode = head;
        
        while(pnode.next != null && pnode.next.val <= currentNode.val ){           
             pnode = pnode.next;
        } 
         
        if(pnode.next != null){
               head.next = currentNode.next;         
               currentNode.next = pnode.next;
               pnode.next = currentNode;
               prevNode = pnode;
            }
        
        while(pnode.next!=null){
            if(pnode.next.val < currentNode.val){
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
          while(tmp.next != null){
            tmp = tmp.next;
          }         
          tmp.next = currentNode;
        
          if(head.next == null){
             head.next = currentNode;
          }
          
        ListNode head0 = new ListNode(0);   
        head0.next = currentNode.next;
        sortList(head0);
        
        currentNode.next = head0.next;
        
        return head;
    }
    
     public ListNode sortList(ListNode head){
         ListNode tmp = head;
         ListNode sortedList = new
         while(tmp!=null){
             
             
         }
         return head;
     }
    
}
