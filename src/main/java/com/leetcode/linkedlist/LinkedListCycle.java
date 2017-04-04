package com.leetcode.linkedlist;

import org.junit.Test;

/**
 * Created by guoyong1 on 2017/4/2.
 */
public class LinkedListCycle {

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        l2.next = l1;
        System.out.println(hasCycle(l1));
    }

    public boolean hasCycle(ListNode head){
        if(head == null)
            return false;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }

        return false;
    }

}
