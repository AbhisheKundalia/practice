/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class divideTwoIntegers {
    //
    //simple but need to adjust the final result
    
    public int divide(int dividend, int divisor) {
        if(dividend == 0 || divisor == 1) return dividend;
        
        int sign = 1;
        
        if(dividend < 0) sign *= -1;
        if(divisor < 0) sign *= -1;
        
         if(dividend==Integer.MAX_VALUE&&divisor==Integer.MIN_VALUE) return 0;
         else if(dividend==Integer.MIN_VALUE&&divisor==Integer.MAX_VALUE) return sign < 0? -1:1;
    
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        double t = Math.log10(dividend) - Math.log10(divisor);
        double ret = Math.pow(10, t);
        int result = (int) Math.floor(ret+ 0.0000001);
        
        return sign*result;
    }
    
    
    public int divide2(int dividend, int divisor) {      
        int sign = 1;
        
        if(dividend < 0) sign *= -1;
        if(divisor < 0) sign *= -1;
        
        long dvd = Math.abs((long)dividend); //the overflow and underflow
        long dvs = Math.abs((long)divisor);
        int result = 0;
        int i = 0;
        
        while(dvd >= dvs){
            dvs <<=1;
            i++;
        }
       
        while(dvd < dvs && i > 0){
              i--;
              dvs >>= 1;
              
              if( dvd >= dvs ){
                  result += 1 << i;
                  dvd -= dvs;
              }
              
        }
                
        return sign*result;
        
    }
    
   
    
}
