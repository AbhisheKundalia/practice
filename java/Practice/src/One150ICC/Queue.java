/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package One150ICC;

/**
 *
 * @author admin
 */
public class Queue {
    Node first;
    Node last;
    
    public Node poll(){
        if(first == null) return null;
        
        Node tmp = first;
        first = first.next;
        return tmp;
    }
    
    public Node add(int val){
        Node n = new Node(val);
        if(last == null){
            last = n;
            first = n;
        }else{
          last.next = n;
          last = last.next;
        }
    }
    
    public boolean isEmpty(){
        if(first == null) return true;
        return false;
    } 
}
