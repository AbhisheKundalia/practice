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
public class bestTimeBuyandSell {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        if(prices.length < 1) return maxProfit;
        
        int min = prices[0];
        int i = 1;
        
        while(i < prices.length){
            while(i < prices.length && prices[i - 1] >= prices[i]){
                i++;
            }
            
            min = Math.min(min, prices[i-1]);
            
            while( i < prices.length && prices[i-1] <= prices[i]){
                i++;
            }
            
            
            int profit = prices[i-1] - min;
            maxProfit = Math.max(profit, maxProfit);       
        }
        
        return maxProfit;
    }
    
    public int maxProfit2(int[] prices){
        int maxProfit = 0;
        if(prices.length < 1) return maxProfit;
        
        int i = 1;     
        while(i < prices.length){
            while(i < prices.length && prices[i - 1] >= prices[i]){
                i++;
            }
            
            int min = prices[i-1];
            
            while( i < prices.length && prices[i-1] <= prices[i]){
                i++;
            }
             
           maxProfit += prices[i-1] - min;
        }
        
        return maxProfit;
        
    }
    
    public int maxProfit3(int[] prices) {
        int maxProfit = 0;
        Stack<Integer> peaks = new Stack<Integer>();
        Stack<Integer> profits = new Stack<Integer>();
        
        int i = 1;
        int min = prices[0];
        
        while(i < prices.length){
            while(i < prices.length && prices[i - 1] >= prices[i]){
                i++;
            }
            
            min = Math.min(min, prices[i-1]);
            peaks.push(prices[i-1]);
            
            while( i < prices.length && prices[i-1] <= prices[i]){
                i++;
            }
                      
            int profit = prices[i-1] - min;
            
            peaks.push(prices[i-1]);
            profits.push(Math.max(profit, maxProfit));
        }
        
        int max = 0;
        int max1 = 0;
        
        if(!profits.isEmpty()) maxProfit = profits.pop();
        
        while(!profits.isEmpty()){
            int high = peaks.pop();
            int low = peaks.pop();
            
            max = Math.max(high, max);
            max1 = Math.max(max-low, max1);
            
            int preProfit = profits.pop();
            
            maxProfit = Math.max(maxProfit, preProfit + max1);
            
        }
        
        return maxProfit;
    }
}
