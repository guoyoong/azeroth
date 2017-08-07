package com.leetcode.arrays;
/**
 * Created by guoyong1 on 2017/6/22.
 */

import org.junit.Test;

public class LongestPalindromicSubstring {

    /**
     * https://leetcode.com/problems/longest-palindromic-substring/#/description
     */

    @Test
    public void test() {
        System.out.println(longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        int max = 0, start = 0;
        for(int i=0; i<s.length(); i++){
            int odd = palindromeLen(s, i, i);
            int even = Integer.MIN_VALUE;
            if(i+1 < s.length())
                even = palindromeLen(s, i, i+1);
            odd = Math.max(odd, even);
            if(odd > max){
                max = odd;
                if(odd % 2 == 1)
                    start = i - odd / 2;
                else
                    start = i - (odd - 1) /2;
            }
        }
        return s.substring(start, start+max);
    }

    public int palindromeLen(String s, int left, int right){
        int len = s.length();
        while(left >= 0 && (right < len && s.charAt(left) == s.charAt(right))){
            left--;
            right++;
        }
        return right - left - 1;
    }

    private int lo, maxLen;

    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
