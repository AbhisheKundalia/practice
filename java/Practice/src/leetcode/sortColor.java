/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class sortColor {

    public void sortColors(int[] A) {
        int[] count = new int[3];

        for (int i = 0; i < A.length; i++) {
            switch (A[i]) {
                case 0:
                    count[0]++;
                    continue;
                case 1:
                    count[1]++;
                    continue;
                case 2:
                    count[2]++;
                    continue;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (i < count[0]) {
                A[i] = 0;
            } else if (i < count[0] + count[1]) {
                A[i] = 1;
            } else {
                A[i] = 2;
            }
        }
    }

    public void sortColors2(int[] A) {
        int s = 0;
        int e = A.length - 1;

        int i = s;

        while (i <= e) {
            if (A[i] == 0) {
                A[i] = A[s];
                A[s] = 0;
                s++;
                i++;
                continue;
            }
            
            if (A[i] == 2) {
                A[i] = A[e];
                A[e] = 2;
                e--;
                continue;
            }
                i++;
        }
    }
}
