package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guoyong1 on 2017/3/23.
 */
public class TwoSum {

    @Test
    public void test(){
        int[] result = twoSum(new int[]{2, 7, 10, 11, 12}, 9);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public int[] twoSum(int[] numbers, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++){
            if(map.containsKey(target - numbers[i])){
                result[i] = map.get(target - numbers[i]);
                result[i] = i;
                return result;
            }
            map.put(numbers[i], i);
        }
        return null;
    }
}
