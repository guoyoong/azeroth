package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/26.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversalII {

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
        System.out.println(levelOrderBottom(root));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<levelNum; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            ans.add(0, list);
        }
        return ans;
    }
}
