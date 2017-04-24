package com.leetcode.math;
/**
 * Created by guoyong1 on 2017/4/18.
 */

import org.junit.Test;

public class MultiplyStrings {

    @Test
    public void test() {
        System.out.println(multiply2("100000", "1"));
    }

    public String multiply2(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) if (!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";
        String ans = "";
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for (int i = 0; i < num2.length(); i++) {
            String s = mul(num1, num2.charAt(i) - '0');
            for (int j = 0; j < i && !"0".equals(s); j++)
                s += "0";
            ans = addTwo(ans, s);
        }
        return ans;
    }

    public String mul(String str, int num) {
        if (num == 0)
            return "0";
        String ans = "";
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            int sum = (str.charAt(i) - '0') * num + left;
            left = sum / 10;
            ans = sum % 10 + ans;
        }
        if (left > 0)
            ans = left + ans;
        return ans;
    }

    public String addTwo(String s1, String s2) {
        if ("".equals(s1) || "0".equals(s1))
            return s2;
        if ("".equals(s2) || "0".equals(s2))
            return s1;
        s1 = new StringBuilder(s1).reverse().toString();
        s2 = new StringBuilder(s2).reverse().toString();
        int left = 0;
        String ans = "";
        for (int i = 0; i < s1.length() || i < s2.length(); i++) {
            int sum = left;
            if (i < s1.length())
                sum += s1.charAt(i) - '0';
            if (i < s2.length())
                sum += s2.charAt(i) - '0';
            ans = sum % 10 + ans;
            left = sum / 10;
        }
        if (left > 0)
            ans = left + ans;
        return ans;
    }

}
