package com.leetcode.hashtable;
/**
 * Created by guoyong1 on 2017/4/10.
 */

import org.junit.Test;

import java.util.*;

public class RepeatedDNASequences {

    @Test
    public void test() {
        List<String> ret = findRepeatedDnaSequences("AAAAAAAAAAAAA");
        for(String s : ret)
            System.out.println(s);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<String>();
        if(s == null || s.length() <= 10)
            return ret;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<=s.length() - 10; i++){
            String sub = s.substring(i, i+10);
            if(map.containsKey(sub) && map.get(sub) == 1) {
                ret.add(sub);
                map.put(sub, map.get(sub)+1);
            }else if(!map.containsKey(sub))
                map.put(sub, 1);
        }
        return ret;
    }
}
