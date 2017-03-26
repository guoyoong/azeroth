package com.leetcode.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by y on 2017/3/24.
 */
public class AddFourSum {

    @Test
    public void test(){
        for(List<Integer> ans : fourSum(new int[]{0,0,0,0}, 0)){
            for(Integer i : ans){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    List<List<Integer>> ret = new ArrayList<List<Integer>>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++){
            if(i>0 && nums[i] == nums[i-1])
                continue;
            for(int j=i+1; j<nums.length-2; j++){
                if(j !=i+1 && nums[j] == nums[j-1])
                    continue;
                twoSum(nums, j+1, nums.length-1, nums[i], nums[j], target);
            }
        }
        return ret;
    }

    public void twoSum(int[] numbers, int begin, int end, int target1, int target2, int target3){
        int l = begin, r = end;
        while(l < r){
            if(numbers[l] + numbers[r] + target1 + target2 == target3){
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(target1);
                ans.add(target2);
                ans.add(numbers[l]);
                ans.add(numbers[r]);
                ret.add(ans);
                while(l < r && numbers[l]==numbers[l+1])
                    l++;
                while(l < r && numbers[r]==numbers[r-1])
                    r--;
                l++;
                r--;
            }else if(numbers[l] + numbers[r] + target1 + target2 < target3)
                l++;
            else
                r--;
        }
    }
}
