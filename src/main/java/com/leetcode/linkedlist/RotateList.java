package com.leetcode.linkedlist;

import org.junit.Test;

/**
 * Created by guoyong1 on 2017/3/31.
 */
public class RotateList {

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;l2.next = l3;l3.next=l4;l4.next=l5;
        ListNode p = rotateRight(l1, 0);
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null)
            return head;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start, slow = start;
        int count = 0;
        for(;fast.next !=null; count++)
            fast = fast.next;
        for(int i=0; i<(count-k%count); i++)
            slow = slow.next;

        fast.next = start.next;
        start.next = slow.next;
        slow.next = null;

        return start.next;
    }
}
