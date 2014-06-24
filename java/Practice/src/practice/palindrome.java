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
 * DP similar with the word breaks
 *
 */
public class palindrome {

    public static boolean isPalindrom(String s) {
        int len = s.length();
        int i = 0;
     
        while (i < len/2 && s.charAt(i) == s.charAt(len-1-i))  i++;
        
        return i == len/2;
    }

    public static List<List<String>> partition(String s) {
        HashMap<Integer, List<List<String>>> partitions = new HashMap<Integer, List<List<String>>>();
        int len = s.length();

        if (len == 0) {
            return null;
        }

        for (int i = 1; i <= len; i++) {
            List<List<String>> tmp0 = new ArrayList<List<String>>();

            for (int j = 0; j < i; j++) {
                if (isPalindrom(s.substring(j, i))) {
                    if (partitions.containsKey(j)) {
                        for (List<String> tmp1 : partitions.get(j)) {
                            List<String> tmp2 = new ArrayList<String> ();
                            tmp2.addAll(tmp1);
                            tmp2.add(s.substring(j, i));
                            tmp0.add(tmp2);
                        }
                    }else if(j==0){
                        List<String> tmp1 = new ArrayList<String> ();
                        tmp1.add(s.substring(j,i));
                        tmp0.add(tmp1);    
                    }
                }


            }

            if (!tmp0.isEmpty()) {
                partitions.put(i, tmp0);
            }
            
        }

        return partitions.get(len);
    }
    
    public  int minCut(String s) {
        int len = s.length();
        
        if(len == 0) return len;
        
        int[] mincuts = new int[len+1];
        mincuts[0] = -1;
        
        int cuts = 0;
        
        for(int i = 1; i <= len; i++){
            cuts = 0;
            mincuts[i] = i-1;
            
            for(int k = 0; k < i; k++){          
                if(isPalindrom(s.substring(k, i))){
                    cuts = mincuts[k]+1; 
                    
                   if(cuts < mincuts[i]) mincuts[i] = cuts;
                   
                   if(mincuts[i] == 0) break;
                }
            }
        }
        
        return mincuts[len];
    }
}
