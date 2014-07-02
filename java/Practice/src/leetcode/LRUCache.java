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
 * Insertion and lookup requires O(1), we consider using HashMap
 * return the lest recent used cache, we need one method to keep the order.
 * Queue or stack is the way to keep the first or last node
 * 
 * here LinkedHashMap combines the HashMap and Queue
 */
public class LRUCache {
    private int totalCapacity;
    LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
    private int num;
    
    public LRUCache(int capacity){
           this.totalCapacity = capacity;
           this.num = 0;
    }
    
    public int get(int key){
        int value = -1;
        if (linkedHashMap.containsKey(key)){
            value = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
         }
         
         return value;
    }
    public void set(int key, int value){
        if (linkedHashMap.containsKey(key)){
            linkedHashMap.put(key, value);
            return;
        }
        
        if(this.num >= this.totalCapacity){  
           Iterator<Integer> keys= linkedHashMap.keySet().iterator();           
           linkedHashMap.remove(keys.next()); 
           this.num--;
        }
        
        this.num++;
        
        linkedHashMap.put(key, value);
    }
}
