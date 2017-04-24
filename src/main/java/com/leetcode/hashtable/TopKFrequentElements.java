package com.leetcode.hashtable;
/**
 * Created by guoyong1 on 2017/4/13.
 */

import org.junit.Test;

import java.util.*;

public class TopKFrequentElements {

    @Test
    public void test() {
        List<Integer> list = topKFrequent2(new int[]{1,1,1,2,2,3}, 2);
        for(Integer i : list)
            System.out.println(i);
    }

    public List<Integer> topKFrequent2(int[] nums, int k){
        List<Integer> ret = new ArrayList<Integer>();
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 0);
            map.put(nums[i], map.get(nums[i])+1);
        }

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null)
                bucket[freq] = new ArrayList<Integer>();
            bucket[freq].add(key);
        }

        for(int pos = bucket.length - 1; pos>=0 &&ret.size()<k; pos--)
            if(bucket[pos]!= null)
                ret.addAll(bucket[pos]);

        return ret;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ret = new ArrayList<Integer>();
        if(nums == null || nums.length == 0)
            return ret;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 0);
            map.put(nums[i], map.get(nums[i])+1);
        }
        List<Map.Entry<Integer, Integer>> list = new
                ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for(int i=0; i<k; i++)
            ret.add(list.get(i).getKey());
        return ret;
    }
}
