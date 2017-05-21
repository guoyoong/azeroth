package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/28.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PathSumII {

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left=node4;
        node3.left=node5;
        node3.right=node6;
        System.out.println(pathSum(node1, 3));
    }

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return ans;
        pathSumSub(root, sum, new ArrayList<Integer>());
        return ans;
    }

    public void pathSumSub(TreeNode root, int sum, List<Integer> list){
        if(root == null)
            return;
        if(root.left == null && root.right == null && root.val == sum){
            list.add(root.val);
            ans.add(new ArrayList<Integer>(list));
        }else if(root.left == null && root.right == null && root.val != sum)
            return;
        list.add(root.val);
        pathSumSub(root.left, sum - root.val, new ArrayList(list));
        pathSumSub(root.right, sum - root.val, new ArrayList(list));
        return;
    }
}
