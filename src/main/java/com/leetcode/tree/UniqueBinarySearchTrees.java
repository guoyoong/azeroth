package com.leetcode.tree;
/**
 * Created by guoyong1 on 2017/4/24.
 * 二叉搜索树
 */

import org.junit.Test;

public class UniqueBinarySearchTrees {

    @Test
    public void test() {
        System.out.println(numTrees2(2));
    }

    /**
     * DP 分治
     * @param n
     * @return
     */
    public int numTrees2(int n){
        int [] dp = new int[n+1];
        dp[0]= 1;
        dp[1] = 1;
        for(int level = 2; level <=n; level++)
            for(int root = 1; root<=level; root++)
                dp[level] += dp[level-root]*dp[root-1];
        return dp[n];
    }

    /**
     * 超时
     * 卡特兰数， h(n)=h(0)*h(n-1)+h(1)*h(n-2)+....+h(n-1)*h(0);
     * 首先固定其中某一个元素，将剩下的n-1个元素拆分成两个小问题，这两个小问题的规模分别是(0,n-1) (1,n-2) (2,n-3) ... (n-1,0)
     * @param n
     * @return
     */
    public int numTrees(int n){
        if(n == 0)
            return 1;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += numTrees(i)*numTrees(n-i-1);
        }
        return sum;
    }

}
