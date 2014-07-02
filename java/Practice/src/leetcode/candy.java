/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class candy {
    public int candy(int[] ratings){
        int size = ratings.length; 
        int[] candies = new int[size];
        
        candies[0] = 1;
        
        for(int i = 1; i < size; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }else if (ratings[i] == ratings[i-1]){
                candies[i] = candies[i-1];
            }else{
                candies[i] = 1;
                int t = i;
                
                while( t >= 1){
                    if(ratings[t] == ratings[t-1]){
                        candies[t-1] = candies[t]; 
                    }
                    
                    if( (ratings[t] - ratings[t-1])*(candies[t] - candies[t-1]) <= 0){
                        ratings[t-1]++;
                    }
                    t--;
                }
            }
        }
        
        int sum = 0;       
        for(int i=0; i < size; i++){
            sum+= candies[i];
        }   
        
        return sum;
        
    }
    
    /*
     * this one cann't pass the leetcode test
     * 
     */
    public int candy2(int[] ratings){
        
        int i = 1;
        int len = ratings.length;
        int Total = len;
        int preslop = 1;
        int currslop = 1;
        int upcount = 0;
        int count = 0;
              
        while( i < len ){
             currslop = (int) Math.signum(ratings[i] - ratings[i-1]);
             i++;
             
             int same = currslop*preslop;
             if (same == 0){
                  currslop = 1;
                  preslop = 1;
                  break;
             }
                  
             if(same  < 0){
                  //adjust the topest node value             
                  if(currslop == 1) {
                      Total += count*count;
                      Total += upcount < count ? (count - upcount) : 0;
                   }else{
                      upcount = count;
                   }
              
                  count = 0;
                  preslop = currslop;     
             }
             
                  
              count++;
              Total+=currslop*count;
        }
        
        if(currslop < 0){
            Total += count*count;
            Total += upcount < count ? (count - upcount) : 0;
        }
        
        return Total;
    }
    
      public int candy3(int[] ratings){
        
        int i = 1;
        int len = ratings.length;
        int Total = len == 0? 0 : 1;
        
        while( i < len ){
              int upcount = 1;
              int downcount = 1;
              
              while( i < len && ratings[i] > ratings[i-1] ){
                    upcount++;
                    Total +=  upcount;
                    i++;
              } 
              
              while( i < len && ratings[i] < ratings[i-1]){            
                  Total -=  downcount;
                  downcount++;
                  i++;
              } 
              
              //adjust the topest node value             
              if(downcount > 0) {
                  Total += downcount*(downcount - 1);
                  Total += upcount < downcount ? (downcount - upcount) : 0;
              }
              
              while(i < len &&ratings[i] == ratings[i-1] ){
                  Total += 1;
                  i++;
              }
        }
        
        return Total;
    }
    
}
