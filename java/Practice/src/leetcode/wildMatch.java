/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;

/**
 *
 * @author admin
 */
public class wildMatch {

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[] match = new boolean[pLen + 1];
        match[0] = true;
        boolean prev = false;
        boolean curr = false;

        for (int i = 1; i <= pLen; i++) {
            if (p.charAt(i - 1) == '*') {
                match[i] = match[i - 1];
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    curr = prev || match[j - 1];
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    curr = match[j - 1];
                } else {
                    curr = false;
                }

                match[j - 1] = prev;
                prev = curr;
            }
        }

        return match[pLen];
    }

    public boolean isMatch2(String s, String p) {

        if (s.length() > 0 && p.length() == 0) {
            return false;
        }
        if (s.length() == 0) {
            if (p.matches("\\*{0,")) {
                return true;
            }
            return false;
        }

        int startIndex = 0;
        int i = 0;

        while (i < s.length() && i < p.length()) {
            if (p.charAt(i) == '?' || s.charAt(i) == p.charAt(i)) {
                i++;
            } else if (p.charAt(i) == '*') {
                break;
            } else {
                return false;
            }
        }

        if (i < s.length() && i < p.length()) {
            startIndex = i;
        }else if(i < s.length() || !p.substring(i).matches("\\*{1,}")){
            return false;
        }
        
        int pstart = i+1;
        int pend = pstart;

        while (pend < p.length()) {
           
            //get the next part without * from p
            while (pstart < p.length() && p.charAt(pstart) == '*') {
                pstart++;
                pend++;
            }

            while (pend < p.length() && p.charAt(pend) != '*') {
                pend++;
            }

            if(pend == pstart) return true;
            
            //if this is the last part to the end
            if (pend == p.length() && pend > pstart) {
                int j = s.length();
                
                while( pend > pstart && j > startIndex && s.charAt(j-1) == p.charAt(pend-1) || p.charAt(pend-1) == '?'){
                    pend--;
                    j--;
                }
                
                if(pend == pstart && j >= startIndex) return true;
                
                return false;
            }

            if (pend > pstart) {
                
                if(startIndex >= s.length()) return false;
                
                int index = getFirstPos(s.substring(startIndex), p.substring(pstart, pend));
                if (index == -1) {
                    return false;
                }
                startIndex = index;
                pstart = pend;
            }
        }

        return true;

    }

    public int getFirstPos(String ssub, String psub) {
        if (psub.length() > ssub.length()) {
            return -1;
        }

        for (int i = 0; i <= ssub.length() - psub.length(); i++) {
            int j = 0;
            int t = i;

            while (j < psub.length()) {
                if (ssub.charAt(t) == psub.charAt(j) || psub.charAt(j) == '?') {
                    j++;
                    t++;
                } else {
                    break;
                }
            }

            if (j == psub.length()) {
                return t;
            }
        }

        return -1;
    }
    
    public boolean isMatch3(String s, String p){
        int sstart = -1;
        int pstart = -1;
        
        int s0 = 0;
        int p0 = 0;
        
        while(s0 < s.length()){
                
            if( p0 < p.length() && s.charAt(s0) == p.charAt(p0) || p.charAt(p0) == '?'){
                s0++;
                p0++;
            }else if( p0 < p.length() && p.charAt(p0) == '*'){
                   sstart = s0;
                   pstart = p0;
                   p0++;
                   
                   if(p0 == p.length()) return true;                   
               
            }else if(pstart > -1){
                p0 = pstart+1;
                s0 = sstart + 1;
                sstart++;
            }else{
                return false;
            }
        }
        
        while(p0 < p.length() && p.charAt(p0) == '*'){
            p0++;
        }
           
        if(p0 < p.length()) return false;
        
        return true;
        
    }
    
   
}
