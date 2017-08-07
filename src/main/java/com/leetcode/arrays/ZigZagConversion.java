package com.leetcode.arrays;
/**
 * Created by guoyong1 on 2017/7/5.
 */

import org.junit.Test;

public class ZigZagConversion {

    @Test
    public void test() {
        System.out.println(convert("PAYPALISHIRING", 2));
    }

    public String convert2(String s, int nRows){
        int len = s.length();
        if (len == 0 || nRows < 2) return s;

        String ret = "";
        int lag = 2*nRows - 2; //循环周期
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < len; j += lag) {
                ret += s.charAt(j);

                //非首行和末行时还要加一个
                if (i > 0 && i < nRows-1) {
                    int t = j + lag - 2*i;
                    if (t < len) {
                        ret += s.charAt(t);
                    }
                }
            }
        }
        return ret;
    }

    public String convert(String s, int numRows){
        if(s == null || s.length() == 0)
            return s;
        String[] sArr = new String[numRows];
        for(int i=0; i<s.length(); i++){
            int sub = i % (numRows*2 - 2);
            if(sub < numRows) {
                sArr[sub] = sArr[sub] == null?(""+s.charAt(i)):(sArr[sub]+s.charAt(i));
            }
            else {
                sArr[numRows * 2 - sub - 2] += s.charAt(i);
            }
        }
        String rs = "";
        for(int i=0; i<numRows; i++)
            rs += sArr[i];
        return rs;
    }

}
