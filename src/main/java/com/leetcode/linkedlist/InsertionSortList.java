package com.leetcode.linkedlist;

import org.junit.Test;

import java.util.List;

/**
 * Created by guoyong1 on 2017/4/3.
 */
public class InsertionSortList {

    @Test
    public void test(){
        ListNode l1 = new ListNode(6);

        ListNode start = insertionSortList(l1);
        while (start != null) {
            System.out.print(start.val + " ");
            start = start.next;
        }
    }

    public ListNode insertionSortList(ListNode head){
        if(head == null)
            return head;
        ListNode dummy = new ListNode(0);
        while(head != null){
            ListNode cur = dummy;
            while(cur.next != null){
                if(cur.next.val < head.val)
                    cur = cur.next;
                else
                    break;
            }
            ListNode headNext = head.next;
            ListNode curNext = cur.next;
            cur.next = head;
            head.next = curNext;
            head = headNext;
        }
        return dummy.next;
    }

}
