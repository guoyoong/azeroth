package com.leetcode.math;
/**
 * Created by guoyong1 on 2017/4/16.
 */

import org.junit.Test;

public class RomanToInteger {

    @Test
    public void test() {
        System.out.println(ramanToInt("IX"));
    }

    public int ramanToInt(String s){
        int[] map = new int[26];
        map['I'-'A'] = 1;
        map['V'-'A'] = 5;
        map['X'-'A'] = 10;
        map['L'-'A'] = 50;
        map['C'-'A'] = 100;
        map['D'-'A'] = 500;
        map['M'-'A'] = 1000;

        int ans = map[s.charAt(s.length()-1)-'A'];
        for(int i=s.length()-2; i>=0; --i){
            int index = s.charAt(i) - 'A';
            if(map[index] < map[s.charAt(i+1) - 'A']){
                ans -= map[index];
            }else{
                ans += map[index];
            }
        }
        return ans;
    }

}
