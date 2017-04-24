package com.leetcode.hashtable;
/**
 * Created by guoyong1 on 2017/4/15.
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {

    @Test
    public void test() {
        System.out.println(findTheDifference2("aaca", "aaaac"));
    }

    public char findTheDifference2(String s, String t){
        int n = t.length();
        char c = t.charAt(n - 1);
        for(int i=0; i<n-1; i++){
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }

    public char findTheDifference(String s, String t){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), 0);
            map.put(s.charAt(i), map.get(s.charAt(i))+1);
        }
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c) > 0)
                    map.put(c, map.get(c)-1);
                else
                    return c;
            }else
                return c;
        }
        return '0';
    }

}
