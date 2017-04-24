package com.leetcode.math;
/**
 * Created by guoyong1 on 2017/4/15.
 */

import org.junit.Test;

public class PalindromeNumber {

    @Test
    public void test() {
        System.out.println(isPalindrome2(1));
    }

    public boolean isPalindrome2(int x){
        if(x < 0)
            return false;
        if(x == 0)
            return true;
        int base = 1;
        while(x / base >= 10)
            base *= 10;

        while(x != 0){
            int left = x / base;
            int right = x % 10;
            if(left != right)
                return false;
            x -= base * left;
            base /= 100;
            x /= 10;
        }

        return true;
    }

    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        long y = x;
        long newX = 0;
        while(x != 0){
            newX = newX * 10;
            newX += x % 10;
            x /= 10;
        }
        if(y == newX)
            return true;
        return false;
    }
}
