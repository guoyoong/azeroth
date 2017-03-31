package com.leetcode.linkedlist;

import org.junit.Test;

/**
 * Created by y on 2017/3/30.
 */
public class SwapNodesInPairs {

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode start = swapPairs(null);
        while (start != null) {
            System.out.print(start.val + " ");
            start = start.next;
        }
    }


    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode p = start;
        while(p.next !=null && p.next.next != null){
            ListNode first = p.next;
            ListNode after = first.next;
            first.next = after.next;
            after.next = first;
            p.next = after;
            p = p.next.next;
        }
        return start.next;
    }
}
