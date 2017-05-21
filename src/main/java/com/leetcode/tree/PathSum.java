package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/28.
 */

import org.junit.Test;

public class PathSum {

    @Test
    public void test() {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node.left = node2;
        System.out.println(hasPathSum(node, 3));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null && root.val == sum)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
