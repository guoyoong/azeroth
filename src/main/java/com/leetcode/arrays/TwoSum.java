package com.leetcode.arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guoyong1 on 2017/3/23.
 */
public class TwoSum {

    @Test
    public void test(){
        int[] result = twoSum2(new int[]{2, 7, 10, 11, 12}, 9);
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

    /**
     * 无法记录index位置
     * @param numbers
     * @param target
     */
    public int[] twoSum2(int[] numbers, int target){
        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        Arrays.sort(numbers);
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                result[0] = left;
                result[1] = right;
                return result;
            }else if(sum < target){
                left++;
            }else
                right--;
        }
        return null;
    }
}
