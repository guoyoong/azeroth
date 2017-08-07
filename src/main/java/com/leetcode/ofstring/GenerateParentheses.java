package com.leetcode.ofstring;
/**
 * Created by guoyong1 on 2017/7/6.
 * https://leetcode.com/problems/generate-parentheses/#/description
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    @Test
    public void test() {
        for(String str : generateParenthesis(3)){
            System.out.println(str);
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> res;
        if (n == 0) {
            res = new ArrayList<>();
            res.add("");
        }
        if (n == 1) {
            res = new ArrayList<>();
            res.add("()");
            return res;
        }
        List<String> ans = new ArrayList<>();
        res = generateParenthesis2(n - 1);
        String tmp;
        for (String str : res) {
            String before = "(" + str;
            for (int i = 0; i < before.length() - 1; i++) {
                if (before.charAt(i) == '(') {
                    tmp = before.substring(0, i + 1) + ")"
                            + before.substring(i + 1);
                    if (!ans.contains(tmp))
                        ans.add(tmp);
                }
            }
        }
        return ans;
    }


    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str + "(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}
