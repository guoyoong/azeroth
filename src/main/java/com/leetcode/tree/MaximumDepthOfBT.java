package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/26.
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBT {

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
        System.out.println(maxDepth2(root));
    }

    public int maxDepth2(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth2(root.left)
                ,maxDepth2(root.right) );
    }

    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        int d = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            d++;
            int size = queue.size();
            for(int i=0; i<size; i++){
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                queue.poll();
            }
        }
        return d;
    }
}
