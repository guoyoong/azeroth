package com.leetcode.math;
/**
 * Created by guoyong1 on 2017/4/18.
 */

import org.junit.Test;

public class PowXN {

    @Test
    public void test() {
        System.out.println(myPow(2, -3));
    }

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 0.0)
            return x;
        if (n == 1)
            return x;
        if (n == -1)
            return 1 / x;
        double y = myPow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else{
            if (n > 0)
                return x * y * y;
            else
                return 1 / x * y * y;
        }

    }
}
