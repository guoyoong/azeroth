package com.leetcode.arrays;

import org.junit.Test;

/**
 * Created by y on 2017/3/25.
 */
public class RemoveDuplicatesFromSortedArray {

    @Test
    public void test(){
        removeDuplicates(new int[]{1,1,2,2,4,4,4,5,6});
    }

    public int removeDuplicates(int[] nums){
        int len = 0;
        int k = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[++len] = nums[i];
            }else
                k++;
        }
        return nums.length - k;
    }

}
