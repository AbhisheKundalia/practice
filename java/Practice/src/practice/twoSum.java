/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.*;

/**
 *
 * @author admin
 */
public class twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    
                    return result;
                }
            }
        }
        
        return result;
    }
    
    //this does include the two numbers could be the same
    public int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < numbers.length; i++){
            
            index.put(numbers[i], i+1); // not the index, should be index+1
        }
        
        Arrays.sort(numbers);
        
        int i = 0, j = numbers.length-1;
        while( i < j ){
            if(numbers[i] + numbers[j] > target) j--;
            if(numbers[i] + numbers[j] < target) i++;
            if(numbers[i] + numbers[j] == target) break;
        }
        
        int index1 = index.get(numbers[i]);
        int index2 = index.get(numbers[j]);
        
        if(index1 > index2){
            result[0] = index2+1;
            result[1] = index1+1;
        }else{
            result[0] = index1+1;
            result[1] = index2+1;
        }
        
        return result;
    }
    
     public int[] twoSum2(int[] numbers, int target) {
           HashMap<Integer, Integer> index = new HashMap<Integer, Integer> ();
           int[] result = new int[2];
           
           for(int i = 0; i < numbers.length; i ++){
               if(index.containsKey(numbers[i])){
                   result[0] = index.get(numbers[i]);
                   result[1] = i + 1;
                   
                   break;
               }
               
               index.put(target - numbers[i], i+1);
           }
           
           return result;
           
     }
    
}
