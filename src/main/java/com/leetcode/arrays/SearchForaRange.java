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
        if (nums == null || nums.length == 0)
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

    // 在target刚好处在最中间位置，时候会出现O(N)的复杂度。
    public int[] searchRange3(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int n = nums.length;
        int[] res = {-1, -1};
        int start = 0, end = n-1;
        while (nums[start] < nums[end]) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) end = mid - 1;
            else if (nums[mid] < target) start = mid + 1;
            else {
                if (nums[start] < target) start++;
                if (nums[end] > target) end--;
            }
        }
        if (nums[start] == target) {
            res[0] = start;
            res[1] = end;
        }
        return res;
    }

    public int[] searchRange2(int[] A, int target) {
        int start = firstGreaterEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, firstGreaterEqual(A, target + 1) - 1};
    }

    //find the first number that is greater than or equal to target.
    //could return A.length if target is greater than A[A.length-1].
    //actually this is the same as lower_bound in C++ STL.
    private int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }
}
