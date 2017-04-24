package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/22.
 */

import org.junit.Test;

import java.util.*;

public class PostorderTraversal {

    public class PostTreeNode{
        TreeNode node;
        boolean isBisited;
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root.right=root2;
        root2.left=root3;
        for(Integer i : postorderTraversal3(root))
            System.out.println(i);
    }

    /**
     * 记录是否访问过
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> set = new HashSet<TreeNode>();
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null)
            return ans;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                set.add(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                TreeNode tmp = stack.pop();
                if(set.contains(tmp)){//第一次出现栈顶
                    stack.push(tmp);
                    root = tmp.right;
                    set.remove(tmp);
                }else{//第二次
                    ans.add(tmp.val);
                }
            }
        }
        return ans;
    }

    /**
     * 修改pre order为：root right left 然后reverse
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null)
            return ans;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }
        Collections.reverse(ans);
        return ans;
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null)
            return ans;
        ans.addAll(postorderTraversal(root.left));
        ans.addAll(postorderTraversal(root.right));
        ans.add(root.val);
        return ans;
    }
}
