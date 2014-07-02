/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 * 
 *  pow : n < 0
 *        采用二分法 ：time cost =  logn
 *        
 */
public class sqrt {
    public int sqrt(int x) {
        if(x<=0) return 0;
        
        double t = Math.log10(x);
        t = t/2;
        
        double result = Math.pow(10.0, t);
        
        return (int) result;
    }
    
    public double pow(double x, int n) {
        if(n==0) return 1.0;
        
        double result = 1.0;
        double t = x;
        if(n < 0) t = 1.0/t;
        
        result = pow(x, n/2);
        
        if(n%2 == 0) {
            return result*result;
        }else{
            return result*result*t;
        }
        
    }
}
