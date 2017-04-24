package com.leetcode.math;
/**
 * Created by guoyong1 on 2017/4/16.
 */

import org.junit.Test;

public class IntegerToRoman {

    @Test
    public void test() {
        System.out.println(intToRoman(9));
    }

    public String intToRoman(int num) {
        String[][] roman = {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}
        };

        String str = "";
        int i = 0;
        while(num != 0){
            int sub = num % 10;
            num /= 10;
            str = roman[i++][sub] + str;
        }
        return str;
    }

}
