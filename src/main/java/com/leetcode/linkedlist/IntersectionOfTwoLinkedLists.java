package com.leetcode.linkedlist;
/**
 * Created by guoyong1 on 2017/4/3.
 */

import org.junit.Test;

public class IntersectionOfTwoLinkedLists {

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(7);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(11);
        ListNode l8 = new ListNode(13);
        ListNode l9 = new ListNode(15);
        ListNode l10= new ListNode(17);
        ListNode l11 = new ListNode(19);
        ListNode l12 = new ListNode(21);
        l1.next=l3;
        l3.next=l4;
        l4.next=l5;l5.next=l6;l6.next=l7;l7.next=l8;l8.next=l9;l9.next=l10;
        l10.next=l11;l11.next=l12;

        ListNode l2 = new ListNode(2);

        ListNode re = getIntersectionNode(l1, l2);
        if(re != null){
            System.out.println(re.next);
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lenA = 0, lenB = 0;
        ListNode pA = headA, pB = headB;
        while(pA != null){
            lenA++;
            pA = pA.next;
        }
        while(pB != null){
            lenB++;
            pB = pB.next;
        }
        pA = headA;
        pB = headB;
        if(lenA >= lenB){
            for(int i=0; i<(lenA-lenB); i++)
                pA = pA.next;
        }else {
            for(int i=0; i<(lenB-lenA); i++)
                pB = pB.next;
        }

        while(pA != pB){
            pA = pA.next;
            pB = pB.next;
        }

        return pA;
    }
}
