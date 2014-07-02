/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class zigzagConversion {
   public String convert(String s, int nRows) {
        String res = "";
        int len = s.length();
        
        if(nRows < 2) return s;
        int gap = 2*nRows - 2;
        
          for(int j = 0; j < nRows; j++){
              for(int i = 0; i <= len/gap; i++){
               
                int index0 = i*gap + j;
                int index1 = (i+1)*gap - j;
                
                if(index0 < len) res += s.substring(index0, index0 + 1);
                if(index1 < len && index1 != index0 && j > 0  ) res += s.substring(index1, index1+1);      
                
            }
        }
        
        return res;
    } 
}
