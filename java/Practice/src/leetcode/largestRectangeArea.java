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
public class LargestRectangleArea {
    public int largestRectangleArea(int[] height) {
        int maxArea = 0;
        int n = height.length;
        
        int[] shortestHeight = new int[n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                shortestHeight[j] = Math.min(height[i], shortestHeight[j]);
                int area = shortestHeight[j]*(i-j+1);
                maxArea = Math.max(maxArea, area);
            }
            
            shortestHeight[i] = height[i];
            maxArea = Math.max(maxArea, height[i]);
        }
        
        return maxArea;
        
    }
    
    public int largestRectangleArea2(int[] height) {
        int maxArea = 0;
        int n = height.length;
        
        int[] shortestHeight = new int[n];
        
        for(int i = 0; i < n;){
            int start = i;
            int end = i;
            
            while(start >= 0 && height[i] <= height[start]){
                start--;
            }
            
            while(end < n && height[i] <= height[end]){
                end++;   
            }
            
            int area = (end - start - 1) * height[i];
            maxArea = Math.max(area, maxArea);
            
            i++;
            while(i < n && height[i] == height[i-1]){
                i++;
            }
            
        }
        
        return maxArea;
        
    }
    
     public int largestRectangleArea3(int[] height) {
        int maxArea = 0;
        int n = height.length;
        
        boolean[] visited= new boolean[n];
        int i = 0;
        int start = 0;
        int end = 0;
        
        while( start < n ){
            
            end = i;
            while(end < n && height[i] <= height[end]){
                
                if(height[i] == height[end]){
                    visited[end] = true;
                }
                
                end++;   
            }
            
            visited[i] = true;
            
            int area = (end - start) * height[i];
            maxArea = Math.max(area, maxArea);
           
            i = end;
            
            if(i >= n){
                while( start < n && visited[start]){
                    start++;
                }
                i = start;
            }
           
        }
        
        return maxArea;
        
    }
     
      public int largestRectangleArea4(int[] height) {
        int maxArea = 0;   
        Stack<Integer> index = new Stack<Integer>();
        Stack<Integer> heights = new Stack<Integer>();
        
        index.push(0);
        heights.push(0);
        
        int i = 1;
        int index0 = 1;
        
        while(i <= height.length){
           int h = heights.peek();
           
           if(height[i-1] >= h){
               index.push(index0);
               heights.push(height[i-1]);
               i++;
               index0 = i;
           }else{
               index0 = index.pop();
                h = heights.pop();
                
                maxArea = Math.max(h*(i-index0), maxArea);
              
           }
         }
        
        while(!index.isEmpty()){
             maxArea = Math.max(heights.pop()*(height.length + 1 -index.pop()), maxArea);
        }
        
        return maxArea;
        
    }
      
      public int largestRectangleArea5(int[] height) {  
        
       Stack<Integer> S = new Stack<Integer>();
       int n = height.length;
       
       int[] h = new int[n +1 ];
       h = Arrays.copyOf(height, n);
       h[n] = 0;
       
       int sum = 0;  
       for (int i = 0; i <= n; i++) {  
            if (S.empty() || h[i] > h[S.peek()]) S.push(i);  
            else {  
                 int tmp = S.pop();   
                 sum = Math.max(sum, h[tmp]*(S.empty()? i : i-S.peek()-1));                 
                 i--;  
            }         
       }  
       
       return sum;  
 }  
        
}
