package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/30.
 */

import org.junit.Test;

public class FlattenBinaryTreeToLinkedList {

    @Test
    public void test() {

    }

    public void flatten3(TreeNode root){
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode p = cur.left;
                while(p.right != null)
                    p = p.right;
                p.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    TreeNode pre = null;
    public void flatten2(TreeNode root){
        if(root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    public void flatten(TreeNode root) {
        if(root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        TreeNode node = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null)
            root = root.right;
        root.right = node;

    }
}
