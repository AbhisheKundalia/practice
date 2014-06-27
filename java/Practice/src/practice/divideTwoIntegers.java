/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author admin
 */
public class divideTwoIntegers {
    //
    //simple but need to adjust the final result
    
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        
        int sign1 = 1;
        int sign2 = 1;
        
        if(dividend < 0) sign1 = -1;
        if(divisor < 0) sign2 = -1;
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        double t = Math.log10(dividend) - Math.log10(divisor);
        int result = (int)Math.pow(10, t);
        
        return sign1*sign2*result;
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
