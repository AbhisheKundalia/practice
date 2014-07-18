/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class permutationSequence {
    public String getPermutation(int n, int k) {
        int beginPos = n;
        int num = 1;
        int i = 1;
        
        while( num < k ){
            num *= i;
            i++;
            beginPos--;
        }
        
        if(beginPos > 0){
            beginPos++;
        }
    }
}
