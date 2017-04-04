package com.leetcode.linkedlist;

import org.junit.Test;

/**
 * Created by guoyong1 on 2017/4/1.
 */
public class PartitionList {

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode start = partition(l1, 3);
        while (start != null) {
            System.out.print(start.val + " ");
            start = start.next;
        }

    }

    public ListNode partition(ListNode head, int x){
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode pSmall = small, pBig = big;
        while(head != null){
            ListNode pNext = head.next;
            if(head.val < x) {
                pSmall.next = head;
                pSmall = pSmall.next;
            }else {
                pBig.next = head;
                pBig = pBig.next;
            }
            head.next = null;
            head = pNext;
        }

        pSmall.next = big.next;

        return small.next;
    }

}
