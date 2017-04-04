package com.leetcode.linkedlist;

import org.junit.Test;

/**
 * Created by guoyong1 on 2017/3/31.
 */
public class ReverseNodesInKGroup {

    @Test
    public void test(){

    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while(cur != null && count != k){
            cur = cur.next;
            count++;
        }
        if(count == k){
            cur = reverseKGroup(cur, k);
            while(count-- > 0){
                ListNode headNext = head.next;
                head.next = cur;
                cur = head;
                head = headNext;
            }
            head = cur;
        }
        return head;
    }

}
