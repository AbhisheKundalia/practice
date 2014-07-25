/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 * 
 * if i -> i+1
 * then gasLeft - cost[i] > 0
 * then gasLeft - cost[i] + gas[i+1] > gas[i+1]
 * 
 * 
 */
public class gasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasleft = 0;
        int beginIndex = 0;
        int n = gas.length;
        
        while (beginIndex < n){
            int i = 0;
             while( i < n ){
                   int curr = (i + beginIndex)%n; 
                   gasleft +=gas[curr] -cost[curr]; 
                   
                   if(gasleft < 0){
                         beginIndex += i + 1;
                         gasleft = 0;
                         break;
                     }
                   
                   i++;
              }
             
             if(i == n){
                  return beginIndex;
              }
        } 
              
        return -1;
              
   }
}
