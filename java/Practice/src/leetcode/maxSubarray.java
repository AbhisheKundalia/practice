/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author admin
 */
public class maxSubarray {

    public int maxSubArray(int[] A) {
        int maxSum = 0;
        int sum = 0;
        int i = 0;

        while (i < A.length && A[i] <= 0) {
            i++;
        }

        while (i < A.length) {
            while (i < A.length && A[i] >= 0) {
                sum += A[i];
                i++;
            }

            maxSum = maxSum > sum ? maxSum : sum;

            while (i < A.length && A[i] <= 0) {
                sum += A[i];
                i++;
            }

            if (sum <= 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

    public int maxSubArray1(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];

            maxSum = maxSum > sum ? maxSum : sum;

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

    //A[0..j] 的最大和为A[0..j-1] 或者A[i..j]
    //Here we bottom-up instead of recursion then get the following
    public int maxSubArray2(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int maxSum = A[0];
        int sum = A[0];

        for (int i = 1; i < A.length; i++) {
            sum = A[i] > sum + A[i] ? A[i] : sum + A[i];

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public int maxSubArray3(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        return maxSubArray4(A, A.length);
    }

    public int maxSubArray4(int[] A, int n) {
        int sum = A[n - 1];
        int maxSum = sum;

        for (int j = n; j > 0; j--) {
            sum += A[j - 1];
            maxSum = Math.max(sum, maxSum);
        }

        sum = maxSubArray4(A, n - 1);

        return Math.max(maxSum, sum);
    }

    //divide-conquer
    public int maxSubArray5(int[] A) {
        if (A.length == 0) return 0;
        
        return maxSubarray(A, 0, A.length - 1);
    }

    public int maxSubarray(int[] A, int start, int end) {
        int mid = (start + end) / 2;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int crossMax = Integer.MIN_VALUE;
        int maxSum = 0;
        
        if(start == end) return A[start];
        
        if (mid >= start) {
            leftMax = maxSubarray(A, start, mid);
        }

        if (mid < end) {
            rightMax = maxSubarray(A, mid + 1, end);
        }


        if (mid >= start && mid < end) {
            int sum = A[mid];
            crossMax = A[mid];
            
            for (int j = mid - 1; j >= start; j--) {
                sum += A[j];
                crossMax = Math.max(sum, crossMax);
            }

            crossMax+= A[mid+1];
            sum = crossMax;
            
            for (int i = mid + 2; i <= end; i++) {
                sum += A[i];
                crossMax = Math.max(sum, crossMax);
            }
        }
        
        maxSum = Math.max(leftMax,rightMax);
        maxSum = Math.max(maxSum, crossMax);
        
        return maxSum;
    }
}
