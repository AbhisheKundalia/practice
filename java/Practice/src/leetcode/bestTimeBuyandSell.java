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
    
    public int maxProfitwithOnTrans(int[] prices) {
        int maxProfit = 0;
        int lowestPrice = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++){   
            lowestPrice = lowestPrice < prices[i]? lowestPrice : prices[i];
            int profit = prices[i] - lowestPrice;
            maxProfit = maxProfit > profit ? maxProfit : profit;
        }
        
        
        return maxProfit;
    }
    
     public int maxProfitwithTwoTrans(int[] prices) {
        int maxProfit = 0;
        int[] leftMaxProfit = new int[prices.length];
        int[] rightMaxProfit = new int[prices.length];
        
        int minPrice = Integer.MAX_VALUE;
        
        //scan from the bgining to the end, get the leftMaxProfit for each index i
        // keep track min price in left
        for(int i = 0; i < prices.length; i++){   
            minPrice = minPrice < prices[i]? minPrice : prices[i];
            int profit = prices[i] - minPrice;
            leftMaxProfit[i] = maxProfit > profit ? maxProfit : profit;
        }
        
        int maxPrice = 0;
        maxProfit = 0;
        
        //scan from the end to the begining, and get the rightMaxProfit for each index i
        // Keep Track the max price in right
        for(int i = prices.length; i > 0; i--){
            int profit = maxPrice - prices[i-1];
            maxProfit = maxProfit > profit ? maxProfit : profit;
            rightMaxProfit[i-1] = maxProfit;
            maxPrice = maxPrice > prices[i-1]? maxPrice : prices[i-1];
        }
        
        maxProfit = 0;
        
        //scan from the beginning to the end, calculate the maxprofit at each i
        // keep the track the maxprofit 
        for(int i = 0; i < prices.length; i++){
           int profit = leftMaxProfit[i] + rightMaxProfit[i];
           maxProfit = profit > maxProfit? profit : maxProfit;
        }
        
        return maxProfit;
    }
     
     //add all positive profit together
      public int maxProfitwithManyTrans(int[] prices) {
        int profit = 0;
        
        for(int i = 1; i < prices.length; i++){
            int diff = prices[i] - prices[i-1];
            profit += diff > 0 ? diff : 0;
        }
        
        return profit;
    }
    
}
