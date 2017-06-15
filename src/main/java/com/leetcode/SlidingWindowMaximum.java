package com.leetcode;
/**
 * Created by guoyong1 on 2017/6/15.
 */

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class SlidingWindowMaximum {

    @Test
    public void test() {

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
            if (map.containsKey(a[i]))
                map.put(a[i], map.get(a[i]) + 1);
            else
                map.put(a[i], 1);
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
}
