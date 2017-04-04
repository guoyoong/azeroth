package com.leetcode.linkedlist;
/**
 * Created by guoyong1 on 2017/4/4.
 */

import org.junit.Test;

public class DeleteNodeInLinkedList {

    @Test
    public void test() {

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
