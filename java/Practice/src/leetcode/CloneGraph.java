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
 * DP problem
 */
public class CloneGraph {
     public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        
        HashMap<Integer, UndirectedGraphNode> allnodes = new HashMap<Integer, UndirectedGraphNode>(); 
        List<UndirectedGraphNode> newnodes= new ArrayList<UndirectedGraphNode>();
        List<UndirectedGraphNode> oldnodes= new ArrayList<UndirectedGraphNode>();
       
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        allnodes.put(node.label, newNode);
        
        newnodes.add(newNode);
        oldnodes.add(node);
        
      do{  
          List<UndirectedGraphNode> newNext= new ArrayList<UndirectedGraphNode>();
          List<UndirectedGraphNode> oldNext= new ArrayList<UndirectedGraphNode>();
        
          for(int i = 0; i < oldnodes.size(); i++){
              UndirectedGraphNode oldnode = oldnodes.get(i);
            
            if(oldnode.neighbors == null){
                continue;
            }
            
            List<UndirectedGraphNode> oldneibors = oldnode.neighbors;
            List<UndirectedGraphNode> newneibors = new ArrayList<UndirectedGraphNode>();
            
            for(UndirectedGraphNode curr : oldneibors){
                UndirectedGraphNode newnode = null;
                if(allnodes.containsKey(curr.label)){
                   newnode = allnodes.get(curr.label);
                }else{
                  newnode = new UndirectedGraphNode(curr.label);
                  allnodes.put(curr.label, newnode);
                  newNext.add(newnode);
                  oldNext.add(curr);
                }
                newneibors.add(newnode);
            }                  
            newnodes.get(i).neighbors = newneibors;
        }
        
        oldnodes = oldNext;
        newnodes = newNext;
      }while(!oldnodes.isEmpty());
      
      return newNode;
    }
}
