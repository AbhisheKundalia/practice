/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;


/**
 *
 * @author yuanyuan
 * Got wrong answer
 */
public class MaxPoints {
    public int maxPoints(Point[] points){
        int len = points.length;
        
        if(len < 2){
            return len;
        }
        int totalMax = 0;
        int samecount = 1;       
        int max = 0;    
        
        for(int i = 0; i < len; i++){
            HashMap<Float,Integer> linesPoints = new HashMap<Float, Integer>();
            
            if(totalMax >= (len - i)){
                   return totalMax;
               }
            
            for(int j = i+1; j < len; j++){
 
               if(points[i].x==points[j].x && points[i].y == points[j].y){
                   samecount++;
                   break;
               }
               
               float key = ;
               if(points[i].x == points[j].x){
                   key = "x";
               }else{
                  key = (float)(points[j].y - points[i].y)/(points[j].x - points[i].x);
                     
               }
               
               int num = 1;
               
               if(linesPoints.containsKey(key)){
                   num = linesPoints.get(key) + 1;
               }
                                       
               linesPoints.put(key, num);
               max = max < num? num : max;         
               
            }
            
            if(max + samecount > totalMax ) totalMax = max + samecount;
            
            samecount = 1;
            max = 0;
        }
        
        return totalMax;
    }
}
