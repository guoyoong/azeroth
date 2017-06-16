package com.leetcode;
/**
 * Created by guoyong1 on 2017/6/15.
 */

import org.junit.Test;

import java.util.*;

public class SlidingWindowMaximum {

    @Test
    public void test() {
        int[] r = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for(int i : r)
            System.out.println(i);
    }

    public int[] maxSlidingWindow2(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k - 1; i++) {
            if (map.containsKey(a[i]))
                map.put(a[i], map.get(a[i]) + 1);
            else
                map.put(a[i], 1);
        }
        int[] r = new int[a.length - k + 1];
        for (int i = 0, j = k - 1; j < a.length; i++, j++) {
            if (map.containsKey(a[j]))
                map.put(a[j], map.get(a[j]) + 1);
            else
                map.put(a[j], 1);
            r[i] = map.lastKey();
            // 删除第一个元素
            Integer count = map.get(a[j - k + 1]);
            count--;
            if (count == 0)
                map.remove(a[j - k + 1]);
            else
                map.put(a[j - k + 1], count);
        }
        return r;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
            if (!deque.isEmpty() && deque.peekFirst() == i - k) deque.poll();
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.removeLast();
            // 加入新数
            deque.offerLast(i);
            // 队列头部就是该窗口内第一大的
            if ((i + 1) >= k) res[i + 1 - k] = nums[deque.peek()];
        }
        return res;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        if (k <= 0) return new int[0];
        int[] dequeue = new int[k];
        int[] max = new int[nums.length - k + 1];
        int pos = 0, len = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (len > 0 && i - dequeue[pos] >= k) {
                pos = (pos + 1) % k;
                len--;
            }
            if (len == 0) dequeue[(pos + (len++)) % k] = i;
            else {
                while (len > 0 && nums[dequeue[(pos + len - 1) % k]] <= nums[i]) len--;
                dequeue[(pos + (len++)) % k] = i;
            }
            if (i >= k - 1) max[j++] = nums[dequeue[pos]];
        }
        return max;
    }

    public String minWindow(String S, String T) {
        int[] srcHash = new int[255];
        // 记录目标字符串每个字母出现次数
        for(int i = 0; i < T.length(); i++){
            srcHash[T.charAt(i)]++;
        }
        int start = 0,i= 0;
        // 用于记录窗口内每个字母出现次数
        int[] destHash = new int[255];
        int found = 0;
        int begin = -1, end = S.length(), minLength = S.length();
        for(start = i = 0; i < S.length(); i++){
            // 每来一个字符给它的出现次数加1
            destHash[S.charAt(i)]++;
            // 如果加1后这个字符的数量不超过目标串中该字符的数量，则找到了一个匹配字符
            if(destHash[S.charAt(i)] <= srcHash[S.charAt(i)]) found++;
            // 如果找到的匹配字符数等于目标串长度，说明找到了一个符合要求的子串
            if(found == T.length()){
                // 将开头没用的都跳过，没用是指该字符出现次数超过了目标串中出现的次数，并把它们出现次数都减1
                while(start < i && destHash[S.charAt(start)] > srcHash[S.charAt(start)]){
                    destHash[S.charAt(start)]--;
                    start++;
                }
                // 这时候start指向该子串开头的字母，判断该子串长度
                if(i - start < minLength){
                    minLength = i - start;
                    begin = start;
                    end = i;
                }
                // 把开头的这个匹配字符跳过，并将匹配字符数减1
                destHash[S.charAt(start)]--;
                found--;
                // 子串起始位置加1，我们开始看下一个子串了
                start++;
            }
        }
        // 如果begin没有修改过，返回空
        return begin == -1 ? "" : S.substring(begin,end + 1);
    }


    public String minWindow2(String S, String T) {
        String res = "";
        if(S == null || T == null || S.length()==0 || T.length()==0)
            return res;

        HashMap<Character, Integer> dict = new HashMap<>();
        for(int i =0;i < T.length(); i++){
            if(!dict.containsKey(T.charAt(i)))
                dict.put(T.charAt(i), 1);
            else
                dict.put(T.charAt(i), dict.get(T.charAt(i))+1);
        }

        int count = 0;
        int pre = 0;
        int minLen = S.length()+1;
        for(int i=0;i<S.length();i++){
            if(dict.containsKey(S.charAt(i))){
                dict.put(S.charAt(i),dict.get(S.charAt(i))-1);
                if(dict.get(S.charAt(i)) >= 0)
                    count++;
                while(count == T.length()){
                    if(dict.containsKey(S.charAt(pre))){
                        dict.put(S.charAt(pre),dict.get(S.charAt(pre))+1);

                        if(dict.get(S.charAt(pre))>0){
                            if(minLen>i-pre+1){
                                res = S.substring(pre,i+1);
                                minLen = i-pre+1;
                            }
                            count--;
                        }
                    }
                    pre++;
                }
            }//end for if(dict.containsKey(S.charAt(i)))
        }
        return res;
    }
}
