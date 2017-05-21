package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/26.
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeZigZagLevelTraversal {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root22 = new TreeNode(3);
        TreeNode root3 = new TreeNode(2);
        TreeNode root33 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        root.left = root2;
        root.right = root22;
        root.left.right = root3;
        root.right.left = root33;
        root.right.right = root4;
        System.out.println(zigzagLevelOrder2(root));
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if (root == null)
            return wrapList;
        int level = 1;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                if(level % 2 == 0)
                    subList.add(0, node.val);
                else
                    subList.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            wrapList.add(subList);
            level++;
        }
        return wrapList;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if (root == null)
            return wrapList;
        int level = 1;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                stack.push(node);
                subList.add(node.val);
            }
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(level % 2 == 0){
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null)queue.offer(node.right);
                }else{
                    if(node.right != null)queue.offer(node.right);
                    if(node.left != null)queue.offer(node.left);
                }
            }
            wrapList.add(subList);
            level++;
        }
        return wrapList;
    }
}
