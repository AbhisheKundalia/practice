/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class ClimbStairs {
    //Fibonacci sequence
    
    public int climbStairs(int n){
        if(n<2) return 1;
        
        return climbStairs(n-2) + climbStairs(n-1);
    }
    
     public int climbStairs2(int n) {
        if(n < 0) return 0;
        int f0 = 1, f1 = 1;
        int f2 = f0;
        
        for(int i = 2; i <= n; i++){
            f2 = f0+f1;
            f0 = f1;
            f1 = f2;
        }
        
        return f2;
    }
     
     public static int climbstairs3(int n)
     {
      int[] s = {0,1,2};
    
      int number = 2;
      while (number++<n) s[number%3] = s[(number-1)%3] + s[(number-2)%3];     
    
     return s[n%3];  
    } 
     
}
