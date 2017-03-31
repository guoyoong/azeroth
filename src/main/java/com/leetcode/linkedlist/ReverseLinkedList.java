package com.leetcode.linkedlist;

import org.junit.Test;

import java.util.List;

/**
 * Created by guoyong1 on 2017/3/31.
 */
public class ReverseLinkedList {

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;l2.next = l3;l3.next=l4;l4.next=l5;
        ListNode p = reverseList2(l1 );
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode start = new ListNode(0);
        ListNode p = head;
        while(p != null){
            ListNode pNext = p.next;
            ListNode oldNext = start.next;
            start.next = p;
            start.next.next = oldNext;
            p = pNext;
        }
        return start.next;
    }

    public ListNode reverseList2(ListNode head){
        return reverseSub(head, null);
    }

    public ListNode reverseSub(ListNode head, ListNode newHead){
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseSub(next, head);
    }
}
