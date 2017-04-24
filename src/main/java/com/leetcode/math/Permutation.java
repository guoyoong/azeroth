package com.leetcode.math;
/**
 * Created by guoyong1 on 2017/4/21.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    @Test
    public void test() {
        List<List<Integer>> list = permute(new int[]{1,2,3});
        for(List<Integer> k : list)
            System.out.println(k);
        System.out.println(list.size());
    }

    public List<List<Integer>> permute(int[] nums){
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++)
            list.add(nums[i]);
        return permutationSub(new ArrayList<Integer>(), list);
    }

    public List<List<Integer>> permutationSub(List<Integer> init, List<Integer> list){
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(list == null || list.size() == 0){
            ans.add(init);
            return ans;
        }

        for(Integer c : list){
            List<Integer> s = new ArrayList<Integer>(init);
            s.add(c);
            List<Integer> listTmp = new ArrayList<Integer>(list);
            listTmp.remove(c);
            List<List<Integer>> subList = permutationSub(s, listTmp);
            ans.addAll(subList);
        }
        return ans;
    }

}
