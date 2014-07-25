/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class DecodeWay {

    public int numDecodings(String s) {
        int n = s.length();

        if (n < 2) {
            return 1;
        }

        int num = numDecodings(s.substring(1));

        if (n >= 2 && Integer.valueOf(s.substring(0, 2)) <= 26) {
            num += numDecodings(s.substring(2));
        }

        return num;
    }

    public int numDecodings2(String s) {
        int n = s.length();

        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int num0 = 1, num1 = 1, num = 1;

        for (int i = 1; i < n; i++) {
                if(s.charAt(i) != '0'){
                    num = num1;
                }else{
                    num = 0;
                }
                
                if(s.charAt(i-1) != '0' && Integer.valueOf(s.substring(i-1, i+1)) <= 26){
                    num += num0;
                }
                
                if(num == 0) return 0;
            
                num0 = num1;
                num1 = num;
            
        }

        return num;
    }
    
    public boolean isValid(String s){
        if(s.charAt(0) != '0' && Integer.valueOf(s) <= 26) return true;
        
        return false;
    }
}
