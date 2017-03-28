package com.leetcode.arrays;

import org.junit.Test;

/**
 * Created by y on 2017/3/27.
 */
public class SearchInRotatedSortedArray {

    @Test
    public void test(){
        System.out.println(search(new int[]{7,0,1,2,3,4,5,6}, 3));
        System.out.println(search(new int[]{7,0,1,2,3,4,5,6}, 4));
        System.out.println(search(new int[]{7,0,1,2,3,4,5,6}, 5));

    }

    public int search(int[] nums, int target){
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[start] == target)
                return start;
            if(nums[end] == target)
                return end;

            if(nums[mid] < nums[end]){//右边有序
                if(nums[mid] <target && target < nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }else {//左边有序
                if(nums[start] < target && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }
}
