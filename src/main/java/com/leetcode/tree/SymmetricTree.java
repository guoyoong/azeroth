package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/25.
 */

import org.junit.Test;

public class SymmetricTree
{

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root22 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root33 = new TreeNode(3);
        root.left = root2;
        root.right = root22;
        root.left.right = root3;
        root.right.left=root33;
        System.out.println(isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return isSameSub(root.left, root.right);
    }

    public boolean isSameSub(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val == right.val)
            return isSameSub(left.right, right.left) && isSameSub(left.left, right.right);
        return false;
    }
}
