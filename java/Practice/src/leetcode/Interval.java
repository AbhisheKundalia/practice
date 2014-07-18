/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Comparator;
/**
 *
 * @author admin
 */
public class Interval implements Comparable<Interval> {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
      
      public int compareTo(Interval compareInterval){
          return this.start - compareInterval.start;
      }
      
      public static Comparator<Interval> intervalStartComparator = new Comparator<Interval> (){
          public int compare(Interval interval1, Interval interval2){
              return interval1.start - interval2.start;
          }
      };
}
