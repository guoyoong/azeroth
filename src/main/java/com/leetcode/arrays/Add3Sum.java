package com.leetcode.arrays;

import org.junit.Test;

import java.util.*;

/**
 * Created by guoyong1 on 2017/3/24.
 */
public class Add3Sum {

    @Test
    public void test(){
        for(List<Integer> ans : threeSum(new int[]{-1, 0, 1, 2, -1, -4})){
            for(Integer i : ans){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    List<List<Integer>> ret = new ArrayList<List<Integer>>();

    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        for(int i=0; i<nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            twoSum(nums, i+1, nums.length-1, nums[i]);
        }
        return ret;
    }

    public void twoSum(int[] numbers, int begin, int end, int target){
        int l = begin, r = end;
        while(l < r){
            if(numbers[l] + numbers[r] + target == 0){
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(target);
                ans.add(numbers[l]);
                ans.add(numbers[r]);
                ret.add(ans);
                while(l < r && numbers[l]==numbers[l+1])
                    l++;
                while(l < r && numbers[r]==numbers[r-1])
                    r--;
                l++;
                r--;
            }else if(numbers[l] + numbers[r] + target < 0)
                l++;
            else
                r--;
        }
    }
}
