/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if(strs.length < 1) return res;
        res = strs[0];
        int i = 1;
        
        while( i < strs.length && res.length() > 0){
            int j = 0;
            while(j < res.length() && j < strs[i].length() && strs[i].charAt(j) == res.charAt(j)){
                j++;
            }
            res = res.substring(0, j);
            i++;
        }
        
        return res;
    }
}
