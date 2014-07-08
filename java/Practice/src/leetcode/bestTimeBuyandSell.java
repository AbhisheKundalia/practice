/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

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
        
    }
}
