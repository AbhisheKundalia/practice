/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class containerWithWater {
    public int maxArea(int[] height) {
        int start = 0, end = height.length-1;
        int maxArea = 0;
        int currh = 0;
        
        while(start < end){
            currh = Math.min(height[start], height[end]);
            int area = (end - start) * currh;
            
            maxArea = Math.max(maxArea, area);
            
            if(height[start] == currh){
              while(start < end && height[start] <= currh) start++;
            
            }else{
              while(start < end && height[end] <= currh) end--;
       
            }
        }
        
        return maxArea;
    }
}
