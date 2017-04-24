package com.leetcode.hashtable;
/**
 * Created by guoyong1 on 2017/4/13.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII {

    @Test
    public void test() {
        int[] ans = intersect(new int[]{1,2,2,1}, new int[]{2,2,1,1});
        for(int i=0; i<ans.length; i++)
            System.out.println(ans[i]);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, start = 0;
        List<Integer> list = new ArrayList<Integer>();
        while(i < nums1.length && j <nums2.length){
            if(nums1[i] < nums2[j])
                i++;
            else if(nums2[j] < nums1[i])
                j++;
            else{
                list.add(nums1[i]);
                j++;
                i++;
            }
        }
        int[] ans = new int[list.size()];
        for(int ii=0; ii<list.size(); ii++)
            ans[ii] = list.get(ii);
        return ans;
    }
}
