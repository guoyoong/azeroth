package com.leetcode.ofstring;
/**
 * Created by guoyong1 on 2017/7/6.
 */

import org.junit.Test;

import java.util.Stack;

public class ValidParentheses {

    @Test
    public void test() {
        System.out.println(isValid2("([])"));
    }

    public boolean isValid2(String s){
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()){
            if(c == '(')
                stack.push(')');
            else if(c == '[')
                stack.push(']');
            else if(c == '{')
                stack.push('}');
            else if(stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }


    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else {
                if(stack.isEmpty())
                    return false;
                char charP = stack.lastElement();
                if( (c == ')' && charP == '(')
                        || (c == '}' && charP == '{')
                        || (c == ']' && charP == '[')) {
                    stack.pop();
                }else
                    return false;
            }
        }
        return stack.isEmpty();
    }

}
