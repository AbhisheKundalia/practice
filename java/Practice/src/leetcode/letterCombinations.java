/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;
/**
 *
 * @author admin
 */
public class letterCombinations {
     public List<String> letterCombinations(String digits) {
        String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> prevList = new ArrayList<String>();
        prevList.add("");
        
        for(int i = 0; i < digits.length(); i++){
            int digit = digits.charAt(i) - '0';
            List<String> currList = new ArrayList<String>();
            
            for(int j = 0; j < prevList.size(); j++){
                for(int t = 0; t < letters[digit].length(); t++){
                    currList.add(prevList.get(j)+letters[digit].substring(t, t+1));
                }
            }
            
            prevList.clear();
            prevList.addAll(currList);
        }
        
        return prevList;
        
    }
}
