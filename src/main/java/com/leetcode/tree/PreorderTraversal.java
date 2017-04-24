package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/22.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root.right=root2;
        root2.left=root3;
        for(Integer i : preorderTraversal(root))
            System.out.println(i);
    }

    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                ans.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return ans;
    }

    /**
     * 先序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null)
            return ans;
        ans.add(root.val);
        ans.addAll(preorderTraversal(root.left));
        ans.addAll(preorderTraversal(root.right));
        return ans;
    }

}
