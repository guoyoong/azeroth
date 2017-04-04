package com.leetcode.linkedlist;

import org.junit.Test;

/**
 * Created by guoyong1 on 2017/4/2.
 */
public class ReorderList {

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;

//        ListNode start = reorderList(l1);
//        while (start != null) {
//            System.out.print(start.val + " ");
//            start = start.next;
//        }
    }

    public void reorderList(ListNode head){
        if(head == null || head.next == null)
            return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        /* fast 一次走两步 slow */
        ListNode pF = head, pS = head;
        while(pF.next != null && pF.next.next != null){
            pF = pF.next.next;
            pS = pS.next;
        }
        /* 对后面的链表反转 */
        ListNode newDummy = new ListNode(0);
        ListNode cur = pS.next;
        while(cur != null){
            ListNode curNext = cur.next;
            ListNode oldNext = newDummy.next;
            newDummy.next = cur;
            newDummy.next.next = oldNext;
            cur = curNext;
        }

        /* 从新删除end */
        cur = newDummy.next;
        pF = head;
        pS.next = null;
        while(cur != null){
            ListNode curNext = cur.next;
            ListNode oldNext = pF.next;
            pF.next = cur;
            cur.next = oldNext;
            pF = pF.next.next;
            cur = curNext;
        }
        head = dummy.next;
    }
}
