package com.leetcode.linkedlist;

import org.junit.Test;

/**
 * Created by guoyong1 on 2017/4/1.
 */
public class ReverseLinkedListII {

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode start = reverseBetween(l1, 6, 6);
        while (start != null) {
            System.out.print(start.val + " ");
            start = start.next;
        }

    }

    /**
     * 把 m - n的list抠出来，然后再拼回去
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n){
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode front = null, last, cur = start, pre;
        for(int i=0; i<m-1; i++)
            cur = cur.next;
        pre = cur;
        last = cur.next;
        /* pre 源链表最后一个node
        *  front 逆转链表第一个元素
        *  last  最后一个元素
        * */
        for(int i=m; i<=n; i++){
            /* 从源链表中删除*/
            cur = pre.next;
            pre.next = cur.next;
            /* 链到新链表中*/
            cur.next = front;
            front = cur;
        }

        cur = pre.next;
        pre.next = front;
        last.next = cur;
        return start.next;
    }

}
