package com.leetcode.arrays;

import org.junit.Test;

/**
 * Created by y on 2017/3/26.
 */
public class RemoveElement {

    @Test
    public void test(){
        removeElement(new int[]{3, 2, 2, 3}, 3);
    }

    public int removeElement(int[] nums, int val){
        int len = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val)
                nums[len++] = nums[i];
        }
        return len;
    }

}
