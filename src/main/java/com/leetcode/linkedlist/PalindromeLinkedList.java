package com.leetcode.linkedlist;
/**
 * Created by guoyong1 on 2017/4/3.
 */

import org.junit.Test;

public class PalindromeLinkedList {

    @Test
    public void test() {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(3);

        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        System.out.println(isPalindrome(l1));
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        ListNode fast = head ,slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        /* slow后面 的链表逆转*/
        if(fast != null){
            slow.next = reverseList(slow.next);
            slow = slow.next;
        }else{/* 偶数个*/
            slow = reverseList(slow);
        }
        while(slow != null){
            if(head.val != slow.val)
                return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head){
        if(head == null)
            return head;
        ListNode dummy = new ListNode(0);
        while(head != null){
            ListNode dummyNext = dummy.next;
            ListNode headNext = head.next;
            dummy.next = head;
            head.next = dummyNext;
            head = headNext;
        }
        return dummy.next;
    }
}
