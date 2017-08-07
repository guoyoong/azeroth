package com.leetcode.ofstring;
/**
 * Created by guoyong1 on 2017/7/6.
 * https://leetcode.com/problems/longest-common-prefix/#/description
 */

import org.junit.Test;

public class LongestCommonPrefix {

    @Test
    public void test() {
        System.out.println(longestCommonPrefix(new String[]{"abc","abcde", "ab"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        for(int i=0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++){
                if(strs[j].length() == i || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

}
