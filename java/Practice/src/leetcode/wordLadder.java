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
             * here, the time cost is 26*word.length
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
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        Queue<String> words = new LinkedList<String>();
        HashMap<String, List<List<String>>> res = new HashMap<String, List<List<String>>>();
        Queue<String> next = new LinkedList<String>();
        
        words.add(start);
        List<List<String>> tmp0 = new ArrayList<List<String>>();
        List<String> word0 = new ArrayList<String>();
        word0.add(start);
        tmp0.add(word0);
        res.put(start, tmp0);
        dict.remove(start);
        
        while(!words.isEmpty()){
            String currWord = words.poll();
            List<List<String>> tmp = new ArrayList<List<String>>(res.get(currWord));
            res.remove(currWord);
            
            if(currWord.equals(end)){
                return tmp;
            }
            
            /*
             * we use the following code instead of the above transitString method, 
             * here, the time cost is 26*word.length
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
                                 
                       List<List<String>> newtmp = new ArrayList<List<String>> ();
                       for(int j = 0; j < tmp.size(); j++){
                           List<String> newWordList = new ArrayList<String>(tmp.get(j));//notice the java is only pass by reference
                           newWordList.add(newS);
                           newtmp.add(newWordList);
                       }
                       
                       if(res.containsKey(newS)){
                           res.get(newS).addAll(newtmp);
                       }else{
                           next.add(newS);
                           res.put(newS, newtmp);
                       }
                   }
               }       
               
            }
            
            if(words.isEmpty()){
                   while(!next.isEmpty()){
                       String word = next.poll();
                       words.add(word);
                       dict.remove(word);
                   }
               }
            
        }
        
        tmp0.clear();
        
        return tmp0;
    }
}
