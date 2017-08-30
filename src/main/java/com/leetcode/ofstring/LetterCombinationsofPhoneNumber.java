package com.leetcode.ofstring;
/**
 * Created by guoyong1 on 2017/7/6.
 */

import org.junit.Test;
import scala.Char;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofPhoneNumber {

    @Test
    public void test() {
        System.out.println(letterCombinations("123"));
    }

    String[] pn = new String[]{"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();
        if(digits == null || digits.length() == 0)
            return ans;
        int pos = digits.charAt(0)-'0';
        if(digits.length() == 1){
            for(int i=0; i<pn[pos].length(); i++){
                ans.add(pn[pos].charAt(i) + "");
            }
            return ans;
        }

        List<String> sub = letterCombinations(digits.substring(1));
        for(int i=0; i<pn[pos].length(); i++){
            for(String str : sub){
                ans.add(pn[pos].charAt(i) + str);
            }
        }
        return ans;
    }
}
