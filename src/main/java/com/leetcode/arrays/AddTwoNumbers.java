package com.leetcode.arrays;

import org.junit.Test;

/**
 * Created by guoyong1 on 2017/3/23.
 */
public class AddTwoNumbers {

    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            val = x;
        }
    }

    @Test
    public void test(){

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode ans = new ListNode(0);
        ListNode p = ans;
        int rest = 0;
        while(l1 != null || l2 != null){
            rest /= 10;
            if(l1 != null){
                rest += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                rest += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(rest % 10);
            p = p.next;
        }
        if(rest / 10 == 1)
            p.next = new ListNode(1);
        return ans.next;
    }
}
