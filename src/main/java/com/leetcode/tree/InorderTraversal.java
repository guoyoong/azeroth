package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/21.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root.right=root2;
        root2.left=root3;
        for(Integer i : inorderTraversal2(root))
            System.out.println(i);
    }

    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()) {
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }
}
