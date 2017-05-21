package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/25.
 */

import org.junit.Test;

public class SameTree {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root.left = root2;
        root2.right = root3;
        System.out.println(isSameTree(root, null));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
