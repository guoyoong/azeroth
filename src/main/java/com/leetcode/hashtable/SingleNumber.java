package com.leetcode.hashtable;
/**
 * Created by guoyong1 on 2017/4/6.
 */

import org.junit.Test;

public class SingleNumber {

    @Test
    public void test() {

    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0; i<nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }
}
