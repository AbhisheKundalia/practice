/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbs;

/**
 *
 * @author admin
 */
public class ConwayGame {
    public void conwayGame(int[][] seed, int n){
        int count = 0;
        int row = seed.length;
        int col = seed[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < row; j++){
                for(int t = 0; t < col; t++){
                    count = 0;
                    
                    if(j-1 >= 0 && t-1>= 0){
                        if((seed[j-1][t-1]&1) == 1){
                            count++;
                        }
                        
                        if(seed[j-1][t-1] > 1){
                            seed[j-1][t-1] = (seed[j-1][t-1]-2)^ 1;
                        }
                    }
                    
                    if(j-1 >= 0){
                        if((seed[j-1][t]&1) == 1)
                           count++;
                        
                        if(t+1 == col && seed[j-1][t] > 1){
                            seed[j-1][t-1] = (seed[j-1][t-1]-2)^1;
                        }
                    }
                    
                    if(j-1 >= 0 && t+1 < col && ((seed[j-1][t+1]&1) == 1)){
                         count++;
                    }
                    
                    if(t-1 >= 0){
                        if((seed[j][t-1]&1) == 1)count++;
                        
                        if(j+1 == row && seed[j][t-1] > 1){
                            seed[j-1][t-1] = (seed[j-1][t-1]-2)^1;
                        }
                    }
                    
                    if(t+1 < col && ((seed[j][t+1]&1) == 1)){
                        count++;
                    }
                    
                    if(j+1 < row && t -1 >= 0 && ((seed[j+1][t-1]&1) == 1)){
                        count++;
                    }
                    
                    if(j+1 < row && ((seed[j+1][t]&1) == 1)){
                        count++;
                    }
                    
                    if(j+1 < row && t+1 < col && ((seed[j+1][t]&1) == 1)){
                        count++;
                    }
                    
                     if((count|seed[j][t]) == 3){
                         seed[j][t] += 2; 
                     }   
                }
            }
            
            if(seed[row-1][col-1] > 1) seed[row-1][col-1] = (seed[row-1][col-1]-2)^1;
        }
    }
}
