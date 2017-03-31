package com.leetcode.linkedlist;

/**
 * Created by guoyong1 on 2017/3/30.
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        ListNode[] leftList = new ListNode[lists.length/2];
        ListNode[] rightList = new ListNode[lists.length - lists.length/2];
        System.arraycopy(lists, 0, leftList, 0, lists.length/2);
        System.arraycopy(lists, lists.length/2, rightList, 0, lists.length - lists.length/2);
        return mergeTwoLists(mergeKLists(leftList),
                mergeKLists(rightList));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode p = start;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else if (l2.val >= l1.val) {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        p.next = l1 != null ? l1 : l2;

        return start.next;
    }
}
