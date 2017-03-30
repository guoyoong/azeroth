package com.leetcode.linkedlist;

import org.junit.Test;

/**
 * Created by guoyong1 on 2017/3/30.
 */
public class MergeTwoSortedLists {

    @Test
    public void test() {
        ListNode l11 = new ListNode(1);
        ListNode l21 = new ListNode(2);
        ListNode l31 = new ListNode(3);
        ListNode l41 = new ListNode(4);
        ListNode l51 = new ListNode(5);
        l11.next = l21;
        l21.next = l31;
        l31.next = l41;
        l41.next = l51;

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode start = mergeTwoLists(l11, l1);
        while (start != null) {
            System.out.print(start.val + " ");
            start = start.next;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode p = start;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else if (l2.val >= l1.val) {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        p.next = l1 != null ? l1 : l2;

        return start.next;
    }
}
