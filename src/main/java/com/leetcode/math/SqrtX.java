package com.leetcode.math;
/**
 * Created by guoyong1 on 2017/4/20.
 */

import org.junit.Test;

public class SqrtX {

    @Test
    public void test() {
        System.out.println((int)mySqrt(9));
    }

    public int mySqrt(int x){
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
}
