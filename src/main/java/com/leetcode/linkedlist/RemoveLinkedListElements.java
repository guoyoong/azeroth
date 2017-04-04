package com.leetcode.linkedlist;

import org.junit.Test;

/**
 * Created by guoyong1 on 2017/4/3.
 */
public class RemoveLinkedListElements {

    @Test
    public void test(){
        ListNode l11 = new ListNode(1);
        ListNode l21 = new ListNode(2);
        ListNode l31 = new ListNode(3);
        ListNode l41 = new ListNode(4);
        ListNode l51 = new ListNode(5);
        l11.next = l21;
        l21.next = l31;
        l31.next = l41;
        l41.next = l51;

        ListNode start = removeElements(l11, 5);
        while (start != null) {
            System.out.print(start.val + " ");
            start = start.next;
        }
    }

    public ListNode removeElements(ListNode head, int val){
        if(head == null)
            return head;
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode cur = dummy;

        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else
                cur = cur.next;
        }
        return dummy.next;
    }
}
