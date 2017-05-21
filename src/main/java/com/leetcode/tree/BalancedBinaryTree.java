package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/27.
 */

import org.junit.Test;

public class BalancedBinaryTree {

    @Test
    public void test() {

    }

    public boolean isBalanced2(TreeNode root){
        if(root == null)
            return true;
        return height(root)!=-1;
    }

    public int height(TreeNode node){
        if(node == null)
            return 0;
        int lH=height(node.left);
        int rH=height(node.right);
        if(lH==-1 || rH ==-1||lH-rH<-1 || lH-rH>1){
            return -1;
        }
        return Math.max(lH,rH)+1;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(maxDepth2(root.left) - maxDepth2(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth2(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth2(root.left)
                ,maxDepth2(root.right) );
    }
}
