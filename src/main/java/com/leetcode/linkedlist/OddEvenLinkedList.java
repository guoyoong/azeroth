package com.leetcode.linkedlist;
/**
 * Created by guoyong1 on 2017/4/4.
 */

import org.junit.Test;

public class OddEvenLinkedList {

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;l5.next=l6;

        ListNode head = oddEvenList(l1);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode evenCur = dummy;
        ListNode cur = head;
        while(cur.next != null && cur.next.next != null){
            ListNode evenNode = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            evenCur.next = evenNode;
            evenNode.next = null;
            evenCur = evenNode;
        }
        if(cur.next == null){
            cur.next = dummy.next;
        }else if(cur.next.next == null){
            evenCur.next = cur.next;
            cur.next = dummy.next;
        }
        return head;
    }
}
