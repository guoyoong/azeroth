package com.leetcode.linkedlist;

import org.junit.Test;

/**
 * Created by guoyong1 on 2017/3/31.
 */
public class RemoveDuplicatesList {

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(1);
        l1.next = l2;l2.next = l3;l3.next=l4;l4.next=l5;
        ListNode p = deleteDuplicates(l1);
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head){
        if(head == null)
            return head;
        ListNode start = new ListNode(0);
        start.next = head;
        while(head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }

        return start.next;
    }
}
