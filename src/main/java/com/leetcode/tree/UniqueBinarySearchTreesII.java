package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/24.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    @Test
    public void test() {

    }

    /**
     * 中序遍历 123.......n
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] ans = new List[n + 1];
        ans[0] = new ArrayList<TreeNode>();
        if (n == 0)
            return ans[0];
        ans[0].add(null);
        for (int len = 1; len <= n; len++) {
            ans[len] = new ArrayList<TreeNode>();
            for (int j = 0; j < len; j++) {
                //构建树  卡特兰数
                for (TreeNode nodeL : ans[j]) {
                    for (TreeNode nodeR : ans[len - j - 1]) {
                        TreeNode node = new TreeNode(j + 1);//
                        node.left = nodeL;
                        node.right = clone(nodeR, j + 1);
                        ans[len].add(node);
                    }
                }
            }
        }
        return ans[n];
    }

    private TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}
