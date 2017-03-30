package com.leetcode.arrays;

import org.junit.Test;

/**
 * Created by guoyong1 on 2017/3/29.
 */
public class MaximumSubarray {

    @Test
    public void test(){
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 回溯所有的子集合
     */
    public int maxSubArray(int[] nums){
        int maxSofar = nums[0], maxEndingHere = nums[0];
        for(int i=1; i<nums.length; i++){
            maxEndingHere = Math.max(nums[i], maxEndingHere+nums[i]);
            maxSofar = Math.max(maxSofar, maxEndingHere);
        }
        return maxSofar;
    }
}
