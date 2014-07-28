/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;

/**
 *
 * @author admin
 * 
 * 1.先找到start的位置，然后再找end的位置
 * 
 */
public class mergeInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> res = new ArrayList<Interval>(intervals);
        
        int s = -1;
        int e = -1;
        
        while(e < intervals.size() && newInterval.end >= intervals.get(e).start){
            
            if( newInterval.start >= intervals.get(e).start){
                s++;
            }
            
            e++;
        }
              
        if(s >= 0){
            
            if( newInterval.start <= intervals.get(s-1).end){
               newInterval.start = Math.min(newInterval.start, intervals.get(s).start);
            }
            
            newInterval.end = Math.max(newInterval.end, intervals.get(e-1).end);
            e--;
        }
        
        if( s == e && newInterval.start == intervals.get(s).start && newInterval.end == intervals.get(s).end){
            return res;
        }
        
        if( s > 0 && s <= e ){
         
            int i = s;
            
            while(i <= e){
                res.remove(s);
                i++;
            }
            
         }
           
        res.add(s, newInterval);
        
        
        return res;
    }
    
    
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> res = new ArrayList<Interval>(intervals);
        
        int s = 0;
        
        // at index s, the start is correct. we need to merge the end.
        while(s < intervals.size() && newInterval.start >= intervals.get(s).start){
            s++;
        }
        
        if(s > 0 && newInterval.start <= intervals.get(s-1).end){
            s--;
        }else{
            res.add(s, newInterval);
        }
        
        res.get(s).end = Math.max(newInterval.end, res.get(s).end);
        s++;
              
       while( s < res.size() && newInterval.end >= res.get(s).start){
           newInterval.end = Math.max(newInterval.end, res.get(s).end);
           res.remove(s);
       }
        
        return res;
    }
    
    
    //最开始想的是先排序，然后用1的方法。其实不用，因为每次的插入过程本身也就是个排序过程。
    //所以我们就只需要重新建立一个新的list，然后遍历原有的list，进行遍历插入
    
    public List<Interval> merge2(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        
        for(int i = 0; i < intervals.size(); i++){
            insert(res, intervals.get(i));
        }
        
        return res;
     }
     
     public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>(intervals);
        sortIntervals(res, 0, res.size()-1);
        //Arrays.sort(intervals);
        
        int s = 0;
        while( s < res.size() - 1){
            if(res.get(s).end >= res.get(s+1).start){
                res.get(s).end = Math.max(res.get(s).end, res.get(s+1).end);
                res.remove(s+1);
            }else{
                s++;
            }
        }
        
        return res;
     }
     
         
     public void sortIntervals(List<Interval> intervals, int begin, int end){
         if(begin > end) return;
         int s = begin + 1;
         int e = end;
         int pivot = intervals.get(begin).start;
         
         while(e >= s){
             if( intervals.get(s).start > pivot && pivot > intervals.get(begin).start){
                 Interval tmp = intervals.get(s);
                 intervals.remove(s);
                 intervals.add(s, intervals.get(e));
                 intervals.remove(e);
                 intervals.add(e, tmp);
             }
             
             if(intervals.get(s).start <= pivot){
                 s++;
             }
             
             if(pivot <= intervals.get(e).start){
                 e--;
             }
         }
         
         if(end > begin){
             intervals.add(s, intervals.get(begin));
             intervals.remove(begin);
             sortIntervals(intervals, begin, s-2);
             sortIntervals(intervals, s, end);  
         }
         
     }
    
    
}
