package com.leetcode.hashtable;
/**
 * Created by guoyong1 on 2017/4/4.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationAllWords {

    @Test
    public void test() {
        String s = "a";
        List<Integer> ans = findSubString2(s, new String[]{"a"});
        for (int i = 0; i < ans.size(); i++)
            System.out.println(ans.get(i) + " ");

    }

    public List<Integer> findSubString2(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        if (s == null || words == null || words.length == 0)
            return ans;
        int len = words[0].length();

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words)
            map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);

        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> wordsMap = new HashMap<String, Integer>(map);
            for (int j = 0; j < words.length; j++) {
                String str = s.substring(i + j * len, i + j * len + len);
                if (wordsMap.containsKey(str)) {
                    int count = wordsMap.get(str);
                    if (count == 1)
                        wordsMap.remove(str);
                    else
                        wordsMap.put(str, map.get(str) - 1);
                    if (wordsMap.isEmpty()) {
                        ans.add(i);
                        break;
                    }
                } else
                    break;
            }
        }
        return ans;
    }

    /**
     * 最后一个case超时
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null)
            return null;
        List<Integer> ans = new ArrayList<Integer>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else
                map.put(words[i], 1);
        }

        int len = words[0].length();
        for (int i = 0; i <= s.length() - words.length * len; i++) {
            int from = i;
            int count = 0;
            String str = s.substring(from, from + len);
            while (map.containsKey(str) && map.get(str) > 0) {
                map.put(str, map.get(str) - 1);
                count++;
                from += len;
                if (from + len > s.length())
                    break;
                str = s.substring(from, from + len);
            }

            if (count == words.length)
                ans.add(i);
            if (count > 0) {
                map.clear();
                for (int j = 0; j < words.length; j++) {
                    if (map.containsKey(words[j])) {
                        map.put(words[j], map.get(words[j]) + 1);
                    } else
                        map.put(words[j], 1);
                }
            }
        }

        return ans;
    }
}
