/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class strStr {

    public String strStr(String haystack, String needle) {
        int index1 = 0;
        int index2 = 0;

        while (index1 < haystack.length() && index2 < needle.length()) {
            if (haystack.charAt(index1) == needle.charAt(index2)) {
                index1++;
                index2++;
            } else {
                index1 = index1 - index2 + 1;
                index2 = 0;
            }
        }

        if (index2 == needle.length()) {
            return haystack.substring(index1 - index2);
        }

        return null;
    }

    //KMP
    public String strStr2(String haystack, String needle) {
        
        if(needle.length() == 0) return haystack;
        
        int[] F = new int[needle.length() + 1];
        F = buildFailureF(needle);

        int j = 0;
        int i = 0;
        
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                
                if (j == needle.length()) {
                    return haystack.substring(i - j + 1);
                 }
            }else if (j == 0) {
                i++;
            }else j = F[j];
        }


        return null;
    }

    public int[] buildFailureF(String needle) {
        int[] F = new int[needle.length() + 1];
        F[0] = 0;
        F[1] = 0;

        for (int i = 2; i <= needle.length(); i++) {

            int t = F[i - 1];

            while (true) {
                if (needle.charAt(i - 1) == needle.charAt(t)) {
                    F[i] = t + 1;
                    break;
                }

                if (t == 0) {
                    F[i] = 0;
                    break;
                }

                t = F[t];
            }
        }

        return F;
    }
}
