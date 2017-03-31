package com.leetcode.linkedlist;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guoyong1 on 2017/3/31.
 */
public class RemoveDuplicatesListsII {

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;l2.next = l3;l3.next=l4;l4.next=l5;
        ListNode p = deleteDuplicates2(l1);
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }

    public ListNode deleteDuplicates2(ListNode head){
        if(head == null)
            return head;
        ListNode start = new ListNode(Integer.MAX_VALUE);
        start.next = head;
        ListNode pre = start;
        ListNode cur = head;
        while(cur != null){
            while(cur.next !=null && cur.val == cur.next.val)
                cur = cur.next;
            if(pre.next == cur)
                pre = pre.next;// 不是重复节点
            else
                pre.next = cur.next;//是重复节点需要删除

            cur = cur.next;
        }
        return start.next;
    }

    public ListNode deleteDuplicates(ListNode head){
        if(head == null)
            return head;
        ListNode start = new ListNode(Integer.MAX_VALUE);
        start.next = head;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ListNode p = head;
        while(p.next != null){
            if(p.val == p.next.val)
                map.put(p.val, p.val);
            p = p.next;
        }

        p = start;
        while(p.next != null){
            if(map.containsKey(p.next.val)){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }

        return start.next;
    }
}
