package com.leetcode.hashtable;
/**
 * Created by guoyong1 on 2017/4/7.
 */

import org.junit.Test;

import java.util.Arrays;

public class ValidAnagram {

    @Test
    public void test() {
        System.out.println(isAnagram2("anagram", "nagaram"));
    }

    public boolean isAnagram2(String s, String t){
        int[] alphabet = new int[26];
        for(int i=0; i<s.length(); i++)
            alphabet[s.charAt(i) - 'a']++;
        for(int i=0; i<t.length(); i++)
            alphabet[t.charAt(i) - 'a']--;
        for(int i : alphabet)
            if(i != 0)
                return false;
        return true;
    }

    public boolean isAnagram(String s, String t){
        if(s == null && t == null)
            return true;
        if(s.length() == 0 && t.length() == 0)
            return true;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        s = new String(sChar);
        t = new String(tChar);
        if(s.equals(t))
            return true;
        return false;
    }
}
