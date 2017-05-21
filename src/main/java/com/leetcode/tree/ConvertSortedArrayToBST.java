package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/26.
 */

import org.junit.Test;

public class ConvertSortedArrayToBST {

    @Test
    public void test() {
        InorderTraversal in = new InorderTraversal();
        for(Integer i : in.inorderTraversal2(sortedArrayToBST(new int[]{1,2,3,4,5})))
            System.out.println(i);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTSub(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBSTSub(int[] nums, int start, int end){
        if(start > end)
            return null;
        if(start == end)
            return new TreeNode(nums[start]);
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTSub(nums, start, mid-1);
        root.right = sortedArrayToBSTSub(nums, mid+1, end);
        return root;
    }
}
