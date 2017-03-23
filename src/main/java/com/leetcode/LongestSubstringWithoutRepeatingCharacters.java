package com.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by guoyong1 on 2017/3/23.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("bbbb"));
    }


    public int lengthOfLongestSubstring(String s){
        int start = -1;
        int max = -1;
        Set<Character> set = new HashSet<Character>();
        for(int i=0; i<s.length(); i++){
            if(!set.contains(s.charAt(i))){
                max = Math.max(max, i - start);
                set.add(s.charAt(i));
            }else{
                start = i - 1;
                set.clear();
                set.add(s.charAt(i));
            }
        }
        return max;
    }
}
