package com.leetcode.hashtable;
/**
 * Created by guoyong1 on 2017/4/13.
 */

import org.junit.Test;

import java.util.*;

public class IntersectionOfTwoArray {

    @Test
    public void test() {
        int[] ans = intersection(new int[]{1,2,2,1}, new int[]{2,2});
        for(int i=0; i<ans.length; i++)
            System.out.println(ans[i]);

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> intersect = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }

}
