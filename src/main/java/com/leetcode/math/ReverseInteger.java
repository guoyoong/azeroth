package com.leetcode.math;
/**
 * Created by guoyong1 on 2017/4/7.
 */

import org.junit.Test;

public class ReverseInteger {

    @Test
    public void test() {
        System.out.println(reverse(100));
    }

    public int reverse(int x) {
        long ans = 0;
        int left = x;
        while(left != 0){
            ans = ans * 10 + left % 10;
            left = left / 10;
        }
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
            return 0;
        return (int)ans;
    }
}
