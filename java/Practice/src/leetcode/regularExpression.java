/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class regularExpression {
    public boolean isMatch(String s, String p) {
        
        if(s.charAt(0) == p.charAt(0)&& p.charAt(1) != '*'){
            return isMatch(s.substring(1), p.substring(1));
        }else if( (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && p.charAt(1) == '*' ){
            return isMatch(s, p.substring(2))&&isMatch(s.substring(1), p);
        }else if( (s.charAt(0) != p.charAt(0))&& p.charAt(1) == '*' ){
            return isMatch(s, p.substring(2));
        }else{
            return false;
        }
    }
}
