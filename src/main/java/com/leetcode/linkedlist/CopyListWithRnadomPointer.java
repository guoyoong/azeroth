package com.leetcode.linkedlist;

import org.junit.Test;

/**
 * Created by guoyong1 on 2017/4/2.
 */
public class CopyListWithRnadomPointer {

    @Test
    public void test(){
        RandomListNode l1 = new RandomListNode(1);
        RandomListNode l2 = new RandomListNode(2);
        RandomListNode l3 = new RandomListNode(3);
        RandomListNode l4 = new RandomListNode(4);

        l1.next = l2;l2.next = l3;l3.next=l4;
        l1.random=l3;l4.random=l2;
        RandomListNode head = copyRandomList(l1);
        while(head != null){
            System.out.print(head.label);
            if(head.random != null)
                System.out.print(head.random.label);
            System.out.println();

            head = head.next;
        }
    }

    /**
     * 深拷贝一个链表
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        /* 在oldList 拷贝前一个节点*/
        while(head != null){
            RandomListNode addNode = new RandomListNode(head.label);
            addNode.next = head.next;
            addNode.random = head.random;
            head.next = addNode;
            head = head.next.next;
        }
        /* 设置CopyNode random为 random.next*/
        head = dummy.next;
        while(head != null){
            if(head.random != null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        /* 拆分List*/
        RandomListNode newDummpy = new RandomListNode(0);
        RandomListNode newHead = newDummpy;
        newDummpy = newHead;
        head = dummy.next;
        while(head != null){
            newHead.next = head.next;
            newHead = newHead.next;
            head.next = head.next.next;
            head = head.next;
        }

        return newDummpy.next;
    }

}
