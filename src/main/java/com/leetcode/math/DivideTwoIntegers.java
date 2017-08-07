package com.leetcode.math;
/**
 * Created by guoyong1 on 2017/4/16.
 */

import org.junit.Test;

public class DivideTwoIntegers {

    @Test
    public void test() {
        System.out.println(divide(13, 2));
    }

    public int divide(int dividend, int divisor) {
        int flag = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            divisor = 0 - divisor;
            flag = -1;
        }
        long dividend1 = Math.abs((long) dividend);
        long divisor1 = Math.abs((long) divisor);
        long ans = 0;
        while (divisor1 <= dividend1) {
            long tmp = divisor1;
            long cnt = 1;
            while ((tmp <<= 1) <= dividend1)
                cnt <<= 1;
            ans += cnt;
            dividend1 -= (tmp >> 1);
        }
        if (ans > Integer.MAX_VALUE) //Handle overflow.
            return (flag == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return (int) (flag * ans);
    }
}

