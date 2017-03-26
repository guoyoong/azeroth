package com.leetcode;

import org.junit.Test;

/**
 * Created by y on 2017/3/23.
 */
public class MedianOfTwoSortedArrays {

    @Test
    public void test(){
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n - 1;
        int[] arr = new int[m+n];
        m--;n--;
        while(m >= 0 && n>= 0){
            if(nums1[m] > nums2[n])
                arr[len--] = nums1[m--];
            else
                arr[len--] = nums2[n--];
        }
        while(m >= 0)
            arr[len--] = nums1[m--];
        while(n >=0)
            arr[len--] = nums2[n--];
        len = nums1.length + nums2.length;
        if (len % 2 == 1)
            return arr[len / 2];
        else
            return (arr[len / 2] + arr[len / 2 - 1]) / 2.0;
    }
}
