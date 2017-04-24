package com.leetcode.math;
/**
 * Created by guoyong1 on 2017/4/19.
 */

import org.junit.Test;

public class AddBinary {

    @Test
    public void test() {
        System.out.println(addBinary2("11", "11"));
    }

    public String addBinary2(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, left = 0;
        while (i >= 0 || j >= 0) {
            int sum = left;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            ans.append(sum % 2);
            left = sum / 2;
        }
        if (left != 0)
            ans.append(left);
        return ans.reverse().toString();
    }

    public String addBinary(String a, String b) {
        String ans = "";
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int left = 0;
        for (int i = 0; i < a.length() || i < b.length(); i++) {
            int sum = left;
            if (i < a.length())
                sum += a.charAt(i) - '0';
            if (i < b.length())
                sum += b.charAt(i) - '0';
            if (sum == 0 || sum == 1) {
                ans = sum + ans;
                left = 0;
            } else if (sum >= 2) {
                ans = sum % 2 + ans;
                left = 1;
            }
        }
        if (left != 0)
            ans = left + ans;
        return ans;
    }
}
