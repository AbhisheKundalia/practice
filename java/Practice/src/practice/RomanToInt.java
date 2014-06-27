/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.*;

/**
 *
 * @author admin
 * 
 * 
 * 
 * the basic concept : 1. continue vs break 2. we need use object to build hashmap, cann't use char, int etc.
 * 
 * 
 */
public class RomanToInt {
     public String intToRoman(int num) {
       HashMap<Integer,String> intRomanMap = new HashMap<Integer, String>();
       intRomanMap.put(1000, "M");
       intRomanMap.put(900, "CM");
       intRomanMap.put(500, "D");
       intRomanMap.put(400, "CD");
       intRomanMap.put(100, "C");
       intRomanMap.put(90, "XC");
       intRomanMap.put(50, "L");
       intRomanMap.put(40, "XL");
       intRomanMap.put(10, "X");
       intRomanMap.put(9, "IX");
       intRomanMap.put(5, "V");
       intRomanMap.put(4, "IV");
       intRomanMap.put(1, "I");
       
       
       String result = "";
       int[] ints = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
       
       for(int i = 0; num > 0 && i < ints.length; i ++){
           int remainder = num/ints[i];
           num = num%ints[i];
           
           for(int j = 0; j < remainder; j++){
               result += intRomanMap.get(ints[i]);
           }         
       }
       
       return result;
       
    }
     
      public int RomanToInt(String s) {
        HashMap<Character, Integer> romanIntMap = new HashMap<Character, Integer>();
        romanIntMap.put('M', 1000);
        romanIntMap.put('D', 500); 
        romanIntMap.put('C', 100);
        romanIntMap.put('L', 50);
        romanIntMap.put('X', 10);     
        romanIntMap.put('V', 5);
        romanIntMap.put('I', 1);
      
        int num = 0;
        
        for(int i = 0; i < s.length(); i++){
            int value = romanIntMap.get(s.charAt(i));
            
            if( (i != s.length() - 1) && value < romanIntMap.get(s.charAt(i+1))){
                num -= value;
                continue;
            }
            
            num +=value;
        }
        
        return num;
    }
}
