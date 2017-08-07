package com.leetcode.math;
/**
 * Created by guoyong1 on 2017/6/19.
 */

import org.junit.Test;

public class BigDigitalCalculate {

    @Test
    public void test() {
        /**
         * 两个正数相加、相减
         *
         * 负数-负数 = 负数+正数 = 正数-正数
         * 负数-正数 = -(正数+正数)
         * 正数-负数 = 正数+正数
         */
        System.out.println(bigDigitalSub("98", "99"));
    }

    public static String bigDigitalSub(String a, String b) {
        char aArr[] = new StringBuffer(a).reverse().toString().toCharArray();
        char bArr[] = new StringBuffer(b).reverse().toString().toCharArray();
        int res[] = new int[Math.max(a.length(), b.length())];
        char sign = '+';
        if (a.length() < b.length())
            sign = '-';
        else if (a.length() == b.length()) {
            int i = a.length() - 1;
            while (i > 0 && aArr[i] == bArr[i])
                i--;
            if (aArr[i] < bArr[i])
                sign = '-';
        }
        for (int i = 0; i < res.length; i++) {
            int aInt = i < a.length() ? aArr[i] - '0' : 0;
            int bInt = i < b.length() ? bArr[i] - '0' : 0;
            if (sign == '+')
                res[i] = aInt - bInt;
            else
                res[i] = bInt - aInt;

        }
        for (int i = 0; i < res.length - 1; i++) {
            if (res[i] < 0) {
                res[i + 1] = res[i + 1] - 1;
                res[i] = res[i] + 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        if (sign == '-')
            sb.append(sign);
        boolean isBeging = true;
        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i] == 0 && isBeging)
                continue;
            else
                isBeging = false;
            sb.append(res[i]);
        }
        if (sb.toString().equals(""))
            sb.append('0');
        return sb.toString();
    }

    public static String bigDigitalSum(String a, String b) {
        char aArr[] = new StringBuffer(a).reverse().toString().toCharArray();
        char bArr[] = new StringBuffer(b).reverse().toString().toCharArray();
        int res[] = new int[Math.max(a.length(), b.length()) + 1];
        //直接相加
        for (int i = 0; i < res.length; i++) {
            int aInt = i < a.length() ? aArr[i] - '0' : 0;
            int bInt = i < b.length() ? bArr[i] - '0' : 0;
            res[i] = aInt + bInt;
        }
        //处理进位
        for (int i = 0; i < res.length; i++) {
            if (res[i] >= 10) {
                res[i + 1] = res[i + 1] + res[i] / 10;
                res[i] = res[i] % 10;

            }
        }

        StringBuffer realResult = new StringBuffer();
        //判断是否有前置0，如果有不会打印出来
        boolean isBeginning = true;
        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i] == 0 && isBeginning)
                continue;
            else
                isBeginning = false;
            realResult.append(res[i]);
        }
        return realResult.toString();
    }

    public static String bigDigitalSum2(String a, String b) {
        char aArr[] = new StringBuffer(a).reverse().toString().toCharArray();
        char bArr[] = new StringBuffer(b).reverse().toString().toCharArray();
        int maxLen = Math.max(a.length(), b.length());
        int rest = 0;
        String rs = "";
        for (int i = 0; i < maxLen; i++) {
            int sum = rest;
            if (i < a.length())
                sum += aArr[i] - '0';
            if (i < b.length())
                sum += bArr[i] - '0';
            rs = sum % 10 + rs;
            rest = sum / 10;
        }
        if (rest != 0)
            rs = 1 + rs;
        return rs;
    }

}
