package com.leetcode.hashtable;
/**
 * Created by guoyong1 on 2017/4/4.
 */

import org.junit.Test;

import java.util.*;

public class SubstringWithConcatenationAllWords {

    @Test
    public void test() {
        String s = "a";
        List<Integer> ans = findSubString2(s, new String[]{"a"});
        for (int i = 0; i < ans.size(); i++)
            System.out.println(ans.get(i) + " ");

    }

    public List<Integer> findSubstring3(String s, String[] words) {
        int N = s.length();
        List<Integer> indexes = new ArrayList<>(s.length());
        if (words.length == 0) {
            return indexes;
        }
        int M = words[0].length();
        if (N < M * words.length) {
            return indexes;
        }
        int last = N - M + 1;

        //map each string in words array to some index and compute target counters
        Map<String, Integer> mapping = new HashMap<String, Integer>(words.length);
        int [][] table = new int[2][words.length];
        int failures = 0, index = 0;
        for (int i = 0; i < words.length; ++i) {
            Integer mapped = mapping.get(words[i]);
            if (mapped == null) {
                ++failures;
                mapping.put(words[i], index);
                mapped = index++;
            }
            ++table[0][mapped];
        }

        //find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
        int [] smapping = new int[last];
        for (int i = 0; i < last; ++i) {
            String section = s.substring(i, i + M);
            Integer mapped = mapping.get(section);
            if (mapped == null) {
                smapping[i] = -1;
            } else {
                smapping[i] = mapped;
            }
        }

        //fix the number of linear scans
        for (int i = 0; i < M; ++i) {
            //reset scan variables
            int currentFailures = failures; //number of current mismatches
            int left = i, right = i;
            Arrays.fill(table[1], 0);
            //here, simple solve the minimum-window-substring problem
            while (right < last) {
                while (currentFailures > 0 && right < last) {
                    int target = smapping[right];
                    if (target != -1 && ++table[1][target] == table[0][target]) {
                        --currentFailures;
                    }
                    right += M;
                }
                while (currentFailures == 0 && left < right) {
                    int target = smapping[left];
                    if (target != -1 && --table[1][target] == table[0][target] - 1) {
                        int length = right - left;
                        //instead of checking every window, we know exactly the length we want
                        if ((length / M) ==  words.length) {
                            indexes.add(left);
                        }
                        ++currentFailures;
                    }
                    left += M;
                }
            }

        }
        return indexes;
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
                //单词的无缝拼接
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
