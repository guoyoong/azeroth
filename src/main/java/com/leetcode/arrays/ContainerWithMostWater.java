package com.leetcode.arrays;

import com.utils.Utils;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by guoyong1 on 2017/3/24.
 */
public class ContainerWithMostWater {

    @Test
    public void test() {
        Utils.sysout(maxArea(new int[]{4, 6, 2, 6, 7, 11, 12}));
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = -1;
        while(left < right){
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}