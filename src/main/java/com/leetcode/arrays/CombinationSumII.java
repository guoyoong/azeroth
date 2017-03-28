package com.leetcode.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by y on 2017/3/28.
 */
public class CombinationSumII {

    @Test
    public void test() {
        for (List<Integer> ans : combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)) {
            for (Integer i : ans) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    List<Integer> solu = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0)
            return ret;
        Arrays.sort(candidates);
        getCombination(candidates, target, 0, 0);
        return ret;
    }

    public void getCombination(int[] candidates, int target, int sum, int level) {
        if (sum > target)
            return;
        if (sum == target)
            ret.add(new ArrayList<Integer>(solu));
        for (int i = level; i < candidates.length; i++) {
            if (i > level && candidates[i] == candidates[i - 1])
                continue;
            sum += candidates[i];
            solu.add(candidates[i]);
            getCombination(candidates, target, sum, i + 1);
            sum -= candidates[i];
            solu.remove(solu.size() - 1);
        }
    }
}
