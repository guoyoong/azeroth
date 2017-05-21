package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/28.
 */

import org.junit.Test;

public class MinimumDepthOfBT {

    @Test
    public void test() {
    }

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(root.left == null)
            return 1+minDepth(root.right);
        if(root.right == null)
            return 1+minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
