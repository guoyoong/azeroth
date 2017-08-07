package com.leetcode.arrays;

import org.junit.Test;

/**
 * Created by y on 2017/3/26.
 */
public class NextPermutation {

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 7, 6, 5, 4};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

    public void nextPermutation(int[] nums) {
        int index = nums.length - 1;
        while (index > 0) {//index = 0 break
            if (nums[index] > nums[index - 1]) {
                break;
            }
            index--;
        }
        // 5, 4, 3, 2, 1, 递减 没有全排列
        if (index == 0) {
            reverseSort(nums, 0, nums.length - 1);
            return;
        }else{// 1, 2, 3, 7, 6, 5, 4 --》 1, 2, 4, 3, 5, 6, 7
            int val = nums[index - 1];
            int j = nums.length - 1;
            while(j >= index){
                if(nums[j] > val)
                    break;
                j--;
            }
            swap(nums, j, index - 1);
            reverseSort(nums, index, nums.length - 1);
        }

    }

    public void reverseSort(int[] nums, int start, int end) {
        if (start > end)
            return;
        for (int i = start; i <= (start + end) / 2; i++)
            swap(nums, i, start + end - i);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
