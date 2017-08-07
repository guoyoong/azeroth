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
            // start 不能往回走，只能向前走
            if(map.containsKey(s.charAt(i)) && start < map.get(s.charAt(i)))
                start = map.get(s.charAt(i));
            max = Math.max(max, i - start);
            map.put(s.charAt(i), i);
        }
        return max;
    }

    public int lengthOfLS2(String s){
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
