package com.leetcode.arrays;

import org.junit.Test;

/**
 * Created by y on 2017/3/26.
 */
public class SearchForaRange {

    @Test
    public void test(){
        int[] ret = searchRange(new int[]{2, 2}, 1);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }

    public int[] searchRange(int[] nums, int target){
        if(nums.length < 1)
            return new int[]{-1, -1};
        int[] result = new int[2];
        result[0] = lSearch(nums, target);
        result[1] = rSearch(nums, target);
        return result;
    }

    public int lSearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid -1;
        }
        if(nums[left] != target)
            return -1;
        return left;
    }

    public int rSearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        if(nums[right] != target)
            return -1;
        return right;
    }

}
