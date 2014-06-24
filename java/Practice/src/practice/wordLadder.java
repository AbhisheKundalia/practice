/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.*;

/**
 *
 * @author admin
 * 
 *  shot length(s) = 1 + min(short length of transit strings with s )
 * 
 * 
 */
public class wordLadder {

    public int ladderLength(String start, String end, Set<String> dict) {
        HashMap<String, Integer> shortestLens = new HashMap<String, Integer>();
        dict.add(start);
        shortestLens.put(end, 1);
        List<String> currlevel = new ArrayList<String>();
        List<String> nextLevel = new ArrayList<String>();
        currlevel.add(end);

        while (!currlevel.isEmpty()) {
            nextLevel.clear();
            for (int i = 0; i < currlevel.size(); i++) {
               
                //Can not use iterator or loop, we need to conver it to array
                 Object[] arrays = dict.toArray();
                 for(int j = 0; j < arrays.length; j++ ){  
                    String s0 = arrays[j].toString();
                    
                    if (transitStrings(currlevel.get(i), s0)) {
                        int len = shortestLens.get(currlevel.get(i)) + 1;
                        
                        if(s0.equals(start)){
                            return len;
                        }
                        
                        shortestLens.put(s0, len);
                        nextLevel.add(s0);
                        dict.remove(s0);
                       
                    }
                }
            }
            
            currlevel.clear();
            currlevel.addAll(nextLevel);
        }
        
        return shortestLens.containsKey(start)? shortestLens.get(start) : 0;
    }

    public boolean transitStrings(String s, String t) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                n++;
            }
        }

        return n == 1;
    }
    
    
    /*
     * 
     * BFS - Branch first search
     * Use Q instead of arraylist
     */
    
    public int ladderLength2(String start, String end, Set<String> dict) {
        Queue<String> words = new LinkedList<String>();
        Queue<Integer> dist = new LinkedList<Integer>();
         
        words.add(start);
        dist.add(1);
        
        while(!words.isEmpty()){
            String currWord = words.poll();
            int currDist = dist.poll();
            
            if(currWord.equals(end)){
                return currDist;
            }
            
            Object[] arrays = dict.toArray();
            for(int j = 0; j < arrays.length; j++ ){  
                if(transitStrings(arrays[j].toString(), currWord)){
                    words.add(arrays[j].toString());
                    dist.add(currDist+1);
                    dict.remove(arrays[j].toString());
                } 
             }
            
        }
        
        return 0;
        
    }
    
    public int ladderLength3(String start, String end, Set<String> dict) {
        Queue<String> words = new LinkedList<String>();
        Queue<Integer> dist = new LinkedList<Integer>();
         
        words.add(start);
        dist.add(1);
        
        while(!words.isEmpty()){
            String currWord = words.poll();
            int currDist = dist.poll();
            
            if(currWord.equals(end)){
                return currDist;
            }
            
            /*
             * we use the following code instead of the above transitString method, 
             * here, the time cost is 32*word.length
             * 
             * the above would be dict.size()*word.length
             * 
             * For large dict set, the following would be better
             */
            for(int i = 0; i < currWord.length(); i++){
               char[] chars = currWord.toCharArray();
               
               for(char c = 'a'; c <= 'z'; c++){
                   chars[i] = c;
                   String newS = String.valueOf(chars); // we cann't use .toString() here 
                   
                   if(dict.contains(newS)){
                       words.add(newS);
                       dist.add(1+currDist);
                       dict.remove(newS);
                   }
               }
            }
            
        }
        
        return 0;
        
    }
}
