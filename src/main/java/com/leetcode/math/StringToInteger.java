package com.leetcode.math;
/**
 * Created by guoyong1 on 2017/4/7.
 */

import org.junit.Test;

public class StringToInteger {

    @Test
    public void test() {

//        System.out.println(myAtoi("-2147483648"));
        System.out.println(Integer.MAX_VALUE);

    }

    public int myAtoi(String str){
        if(str == null || str.length() == 0)
            return 0;
        str = str.trim();
        int i = 0, sign = 1;
        long base = 0;
        if(str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if(str.charAt(i) == '+') {
            sign = 1;
            i++;
        }
        while(i < str.length()){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                // 超过 最大值 || 恰好等于最大值
                if(base > Integer.MAX_VALUE / 10
                        || (base == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0' > 7))){
                    if(sign == 1)
                        return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                }
                base = base * 10 + (str.charAt(i++) - '0');
            }else
                break;
        }
        base = base * sign;
        return (int)base;
    }
}
