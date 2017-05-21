package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/25.
 */

import org.junit.Test;

import java.util.Stack;

public class ValidBinarySearchTree {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root2.left = root;
        root2.right = root3;
        System.out.println(isValidBST2(root));
    }

    public boolean isValidBST2(TreeNode root){
        return isValidBST2Sub(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValidBST2Sub(TreeNode root, long max, long min){
        if(root == null)
            return true;
        if(root.val >= max || root.val <= min)
            return false;
        return isValidBST2Sub(root.left, root.val, min) &&
                isValidBST2Sub(root.right, max, root.val);
    }

    public boolean isValidBST(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
