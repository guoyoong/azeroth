package com.leetcode.arrays;

import com.utils.Utils;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by guoyong1 on 2017/3/24.
 */
public class ThreeSumClosest {

    @Test
    public void test(){
        Utils.sysout(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE / 2, minSum;
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1])
                continue;
            minSum = findMinSum(nums, i+1, nums.length-1, nums[i], target);
            if(Math.abs(ans - target) > Math.abs(minSum - target))
                ans = minSum;
        }
        return ans;
    }

    public int findMinSum(int[] nums, int begin, int end, int numi, int target){
        int ans = Integer.MAX_VALUE / 2;
        int l = begin, r = end;
        while(l < r){
            int sum = nums[l] + nums[r] + numi;
            if(Math.abs(ans - target) > Math.abs(sum - target))
                ans = sum;
            if(sum >= target)
                r--;
            else
                l++;
        }
        return ans;
    }
}
