/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author admin
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
