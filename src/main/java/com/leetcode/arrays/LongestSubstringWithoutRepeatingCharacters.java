package com.leetcode.arrays;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by guoyong1 on 2017/3/23.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }


    public int lengthOfLongestSubstring(String s){
        int start = -1;
        int max = -1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i)) && start < map.get(s.charAt(i)))
                start = map.get(s.charAt(i));
            max = Math.max(max, i - start);
            map.put(s.charAt(i), i);
        }
        return max;
    }
}
