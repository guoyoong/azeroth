package com.leetcode.arrays;

import org.junit.Test;

/**
 * Created by y on 2017/3/27.
 */
public class SearchInsertPosition {

    @Test
    public void test(){
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 1));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 3));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 4));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 6));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));

    }

    public int searchInsert(int[] nums, int target){
        int start = 0, end = nums.length-1;
        while(start <= end){
            int mid = (start + end) /2 ;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }
}
