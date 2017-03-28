package com.leetcode.arrays;

import org.junit.Test;

/**
 * Created by y on 2017/3/28.
 */
public class FirstMissingPositive {

    @Test
    public void test(){
        System.out.println(firstMissingPositive(new int[]{3,5,7}));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 1;
        //把元素放入正确的位置，例如1放在nums[0]，2放在nums[1]...
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] > nums.length || nums[i] <= 0 || nums[i] == nums[nums[i] - 1])
                    break;
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }
}
