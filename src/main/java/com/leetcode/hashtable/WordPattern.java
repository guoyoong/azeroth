package com.leetcode.hashtable;
/**
 * Created by guoyong1 on 2017/4/7.
 */

import org.junit.Test;

import java.util.*;

public class WordPattern {

    @Test
    public void test() {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String str){
        String[] words = str.split(" ");
        if(pattern.length() != words.length)
            return false;
        Map<Character, String> map = new HashMap<Character, String>();
        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(words[i]))
                    return false;
            }else{
                if(map.containsValue(words[i]))
                    return false;
                map.put(c, words[i]);
            }
        }
        return true;
    }
}
