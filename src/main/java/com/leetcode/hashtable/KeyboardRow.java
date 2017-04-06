package com.leetcode.hashtable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by y on 2017/4/6.
 */
public class KeyboardRow {

    @Test
    public void test(){
        String[] strs = findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        for(String s : strs)
            System.out.println(s);
    }

    public String[] findWords(String[] words) {
        if(words == null || words.length == 0)
            return new String[]{};
        String[] strs = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<strs.length; i++){
            for(char c : strs[i].toCharArray())
                map.put(c, i);
        }

        List<String> list = new ArrayList<String>();
        for(String str : words){
            if("".equals(str))
                continue;
            String tmp = new String(str);
            str = str.toUpperCase();
            int index = map.get(str.charAt(0));
            for(char c : str.toCharArray()){
                if(map.get(c) != index){
                    index = -1;
                    break;
                }
            }
            if(index != -1)
                list.add(tmp);
        }
        return list.toArray(new String[0]);
    }

}
