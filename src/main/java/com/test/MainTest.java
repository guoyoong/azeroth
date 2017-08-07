package com.test;
/**
 * Created by guoyong1 on 2017/6/20.
 */

import com.leetcode.linkedlist.ListNode;
import org.junit.Test;

import java.util.*;

public class MainTest {

    @Test
    public void test() {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, front = dummy;
        for(int i=0; i<n; i++){
            p = p.next;
        }
        while(p.next != null){
            front = front.next;
            p = p.next;
        }
        if(front.next != null)
            front.next =front.next.next;

        return dummy.next;
    }
}
