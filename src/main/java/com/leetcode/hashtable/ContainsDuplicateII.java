package com.leetcode.hashtable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by y on 2017/4/6.
 */
public class ContainsDuplicateII {

    @Test
    public void test() {
        System.out.println(containsNearbyDuplicate(new int[]{99,99}, 2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k){
        if(nums == null || nums.length == 0)
            return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                if((k + map.get(nums[i])) >= i)
                    return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
