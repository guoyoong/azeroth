package com.leetcode.hashtable;
/**
 * Created by guoyong1 on 2017/4/6.
 */

import org.junit.Test;

import java.util.*;

public class GroupAnagrams {

    @Test
    public void test() {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0)
            return ret;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        for (int i = 0; i < strs.length; i++) {
            char[] cArr = strs[i].toCharArray();
            Arrays.sort(cArr);
            String newStr = String.valueOf(cArr);
            if (!map.containsKey(newStr))
                map.put(newStr, new ArrayList<String>());
            map.get(newStr).add(strs[i]);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
