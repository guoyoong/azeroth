package com.leetcode.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by guoyong1 on 2017/3/28.
 */
public class CombinationSum {

    @Test
    public void test(){
        for(List<Integer> ans : combinationSum(new int[]{2,3,5,7}, 7)){
            for(Integer i : ans){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /**
     * backtracking
     */
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    List<Integer> solu = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        if(candidates.length == 0)
            return ret;
        Arrays.sort(candidates);
        combinations(candidates, target, 0, 0);
        return ret;
    }

    public void combinations(int[] candidates, int target, int sum, int level){
        if(sum > target)
            return;
        if(sum == target) {
            ret.add(new ArrayList<Integer>(solu));
            return;
        }
        for(int i=level; i<candidates.length; i++) {
            sum += candidates[i];
            solu.add(candidates[i]);
            combinations(candidates, target, sum, i);
            sum -= candidates[i];
            solu.remove(solu.size() - 1);
        }
    }
}
