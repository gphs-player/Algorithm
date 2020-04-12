package com.leo.algorithm.question;

import static com.leo.algorithm.question.DeleteLinkedNode.LinkedNode;

/**
 * 找到链表倒数第K个节点
 */
public class FindKthToTail {

    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(1);

        LinkedNode second = new LinkedNode(2);
        LinkedNode third = new LinkedNode(3);
        LinkedNode fourth = new LinkedNode(4);
        LinkedNode fifth = new LinkedNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        LinkedNode result = find(head, 0);
        System.out.println(result == null ? null : result.value);

    }

    private static LinkedNode find(LinkedNode head, int tail) {
        if (head == null || tail == 0) return null;
        LinkedNode ahead = head;
        LinkedNode behind;
        //先走的指针到达指定位置
        for (int i = 0; i < tail - 1; i++) {
            if (ahead.next != null) {
                ahead = ahead.next;
            } else {
                //tail过大，链表没有那么多节点，返回null
                return null;
            }
        }
        //后走的指针再走
        behind = head;
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }
}
