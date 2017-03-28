package com.leetcode.arrays;

import org.junit.Test;

/**
 * Created by y on 2017/3/26.
 */
public class SearchForaRange {

    @Test
    public void test() {
        int[] ret = searchRange(new int[]{}, 2);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int i = 0, j = nums.length - 1;
        int[] ret = new int[]{-1, -1};

        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target)
                i = mid + 1;
            else
                j = mid;
        }
        if (nums[i] != target)
            return ret;
        else
            ret[0] = i;

        j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2 + 1;
            if (nums[mid] > target)
                j = mid - 1;
            else
                i = mid;
        }
        ret[1] = j;
        return ret;
    }
}
