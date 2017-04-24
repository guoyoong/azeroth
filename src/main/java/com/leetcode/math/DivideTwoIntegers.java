package com.leetcode.math;
/**
 * Created by guoyong1 on 2017/4/16.
 */

import org.junit.Test;

public class DivideTwoIntegers {

    @Test
    public void test() {
        System.out.println(3 << 1);
    }

    public int divide(int dividend, int divisor) {
        boolean flag = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            divisor = 0 - divisor;
            flag = false;
        }
        long dividend1 = Math.abs((long) dividend);
        long divisor1 = Math.abs((long) divisor);
        int ans = 0;
        while (divisor1 <= dividend1) {
            long tmp = divisor1;
            int cnt = 1;
            while ((tmp <<= 1) <= dividend1)
                cnt <<= 1;
            ans += cnt;
            dividend1 -= (tmp >> 1);

        }
        if (!flag)
            return 0 - ans;
        return ans;
//      return dividend/divisor;
    }
}
