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
         StringBuffer res = new StringBuffer("");
        
         if( k < 1) return res.toString();
         
        boolean[] visited = new boolean[n];
        int beginNum = 1;
        int num = 1;
        int i = 1;
        int count = n;
        

        while (num < k) {
              num *= ++i;
         }
       
        
        while(k > 0) {
            while(num >= k){
                num /= i;
                i--;
            }
            
            int j = (k-1)/num;
            k = k- j*num;
            
            while (count > i+1) {
                if(!visited[beginNum-1])
                {
                    res.append(beginNum);
                    visited[beginNum-1] = true;
                    count--;
                }
                beginNum++;
            }
 
            int t = beginNum;
            while(j >= 0){
              if(!visited[t-1]){
                 j--;     
              }
              t++;
            }
            
            res.append(t-1);
            visited[t-2] = true;
            count--;
        }
        
        while(count > 0){
            if(!visited[beginNum-1])
                {
                    res.append(beginNum);
                    visited[beginNum-1] = true;
                    count--;
                }
                
            beginNum++;
        }
        
        return res.toString();
    }
}
