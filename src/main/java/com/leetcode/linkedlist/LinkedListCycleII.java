package com.leetcode.linkedlist;

import org.junit.Test;

/**
 * Created by guoyong1 on 2017/4/2.
 */
public class LinkedListCycleII {

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        l2.next = l1;
        System.out.println(detectCycle(l1).val);
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return head;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
