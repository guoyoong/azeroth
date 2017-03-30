package com.leetcode.linkedlist;

import org.junit.Test;

/**
 * Created by guoyong1 on 2017/3/30.
 */
public class RemoveNthNodeFromEndOfList {

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;l2.next = l3;l3.next=l4;l4.next=l5;
        ListNode p = removeNthFromEnd(l1, 1);
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }

    /**
     * 关键需要一个start指针。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start, slow = start;
        for(int i=0; i<=n; i++)
            fast = fast.next;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return start.next;
    }
}
