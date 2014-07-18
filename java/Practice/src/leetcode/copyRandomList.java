/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class copyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
           RandomListNode safehead = new RandomListNode(0);
           safehead.next = head;
           RandomListNode prev = safehead;
           RandomListNode p = head;
           int n = 0;
           
           while(p != null){
               RandomListNode newnode = new RandomListNode(p.label);
               prev.next = newnode;
               prev = prev.next;
               p = p.next;
               n++;
           }
           
           p = head;
           RandomListNode currP = safehead.next;
           
           while( p != null){
               RandomListNode next = p.random;
               prev = safehead.next;
               
               int step = 0;
               
               while(next != null){
                   next = next.next;
                   step++;
               }
               
              if(step > 0){
               step = n - step;
               
               while(step > 0){
                   prev = prev.next;
                   step--;
               }
               currP.random = prev;
               
              }
               p = p.next;
               currP = currP.next;
           }
           
           return safehead.next;
    }
    
    //this solution is special. we insert the copied node into the original list.
    //then the ramdomList is just next to the original ramdom pointer
    
    public RandomListNode copyRandomList2(RandomListNode head){
           RandomListNode currP = head;
           
           //copy the node
           while(currP != null){
               RandomListNode tmp = new RandomListNode(currP.label);
               tmp.next = currP.next;
               currP.next = tmp;
               currP = tmp.next;
           }
           
           currP = head;
           //copy the random pointer
           while(currP != null){
               
               if(currP.random != null){
                  currP.next.random = currP.random.next;    
               }
               
               currP = currP.next.next;
           }
           
           //decouple the list
            RandomListNode safehead = new RandomListNode(0);
            RandomListNode p = safehead;
            currP = head;
            
            while(currP != null){
                p.next = currP.next;
                currP.next = currP.next.next;
                currP = currP.next;
                p = p.next;
            }
           
            return safehead.next;
    }
}
