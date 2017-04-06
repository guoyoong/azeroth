package com.leetcode.hashtable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by y on 2017/4/6.
 */
public class ContainsDuplicate {

    @Test
    public void test() {
        System.out.println(containsDuplicate(new int[]{1,2,1}));
    }

    public boolean containsDuplicate(int[] nums){
        if(nums == null || nums.length == 0)
            return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
                return true;
            map.put(nums[i], 1);
        }

        return false;
    }
}
