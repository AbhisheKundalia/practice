/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class pow {
    public double pow(double x, int n) {
        if(n == 0) return 1.0;
        int m = Math.abs(n);
        double result = 0.0;
        
        double tmp = pow(x, m/2);
        
        if(m%2 == 0){
            result = tmp*tmp;
        }else{
            result = tmp*tmp*x;
        }
        
        result = n < 0? 1.0/result : result;
        return result;
    }
}
