package com.leetcode.arrays;

import org.junit.Test;

/**
 * Created by y on 2017/3/23.
 */
public class MedianOfTwoSortedArrays {

    @Test
    public void test() {
        System.out.println(findMSA(new int[]{1, 3}, new int[]{2, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n - 1;
        int[] arr = new int[m + n];
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n])
                arr[len--] = nums1[m--];
            else
                arr[len--] = nums2[n--];
        }
        while (m >= 0)
            arr[len--] = nums1[m--];
        while (n >= 0)
            arr[len--] = nums2[n--];
        len = nums1.length + nums2.length;
        if (len % 2 == 1)
            return arr[len / 2];
        else
            return (arr[len / 2] + arr[len / 2 - 1]) / 2.0;
    }

    public double findMSA(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < A.length) aMid = A[aStart + k / 2 - 1];
        if (bStart + k / 2 - 1 < B.length) bMid = B[bStart + k / 2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k / 2, B, bStart, k - k / 2);// Check: aRight + bLeft
        else
            return getkth(A, aStart, B, bStart + k / 2, k - k / 2);// Check: bRight + aLeft
    }
}
