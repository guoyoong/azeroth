package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/25.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

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
        root.right.left = root33;
        System.out.println(levelOrder(root));
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if (root == null) return wrapList;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    public class LevelTreeNode {
        TreeNode node;
        int level;

        public LevelTreeNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int level = 1;
        List<LevelTreeNode> queue = new LinkedList<LevelTreeNode>();
        queue.add(new LevelTreeNode(root, 1));
        List<Integer> list = new ArrayList<Integer>();
        while (queue.size() > 0) {
            LevelTreeNode node = queue.get(0);
            if (node.level == level) {
                list.add(node.node.val);
                queue.remove(0);
            } else {
                ans.add(list);
                list = new ArrayList<Integer>();
                list.add(node.node.val);
                queue.remove(0);
            }
            level = node.level;
            if (node.node.left != null)
                queue.add(new LevelTreeNode(node.node.left, node.level + 1));
            if (node.node.right != null)
                queue.add(new LevelTreeNode(node.node.right, node.level + 1));
        }
        ans.add(list);
        return ans;
    }
}
