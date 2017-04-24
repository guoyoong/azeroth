package com.leetcode.hashtable;
/**
 * Created by guoyong1 on 2017/4/12.
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {

    @Test
    public void test() {
        System.out.println(getHint("1122", "2211"));
    }

    public String getHint2(String secret, String guess){
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
                if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public String getHint(String secret, String guess){
        if(secret == null || "".equals(secret))
            return secret;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<secret.length(); i++) {
            char c = secret.charAt(i);
            if(!map.containsKey(c))
                map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }
        int cows = 0, bulls = 0;
        for(int i=0; i<secret.length(); i++) {
            char c = guess.charAt(i);
            if (secret.charAt(i) == c) {
                bulls++;
                map.put(guess.charAt(i), map.get(c) - 1);
            }
        }
        for(int i=0; i<secret.length(); i++){
            char c = guess.charAt(i);
            if(secret.charAt(i) != c)
                if (map.containsKey(c) && map.get(c) > 0) {
                    cows++;
                    map.put(guess.charAt(i), map.get(c) - 1);
                }
        }


        return bulls+"A"+cows+"B";
    }
}
