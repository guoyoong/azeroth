package com.leetcode.ofstring;
/**
 * Created by guoyong1 on 2017/7/12.
 * https://leetcode.com/problems/longest-valid-parentheses/#/description
 */

import org.junit.Test;

import java.util.Stack;

public class LongestValidParentheses {

    @Test
    public void test() {

    }

    // stack 记录第一个括号开始位置。
    public int longestValidParentheses3(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {// ()
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                // ())
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(')');
            else if(stack.isEmpty() || stack.pop() != s.charAt(i))
                return false;
        }
        return stack.isEmpty();
    }

    public int longestValidParentheses(String s) {
        int len = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=i+2; j<=s.length(); j+=2){
                if(isValid(s.substring(i, j)))
                    len = Math.max(len, j - i);
            }
        }
        return len;
    }
}
