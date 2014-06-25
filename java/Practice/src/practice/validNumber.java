/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author admin
 * 
 * 3. => true
 * .3 => true
 * 
 */
public class validNumber {
    public boolean isNumber(String s) {
        String number_re = "\\s*[+-]?(\\d+|\\d*\\.\\d+)(e[+-]?\\d+)?\\s*";
        return s.matches(number_re);
    }
}
