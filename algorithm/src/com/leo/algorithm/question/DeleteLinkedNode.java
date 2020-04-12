package com.leo.algorithm.question;

/**
 * 在O(1)的时间删除单向链表的结点
 */
public class DeleteLinkedNode {


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

        deleteNode(head, head);

        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    private static void deleteNode(LinkedNode head, LinkedNode toBeDeleteNode) {
        if (head == null || toBeDeleteNode == null) {
            return;
        }
        //不是尾结点，
        if (toBeDeleteNode.next != null) {
            LinkedNode nextNode = toBeDeleteNode.next;
            toBeDeleteNode.value = nextNode.value;
            toBeDeleteNode.next = nextNode.next;

        }
        //头结点也是尾结点
        else if (head.value == toBeDeleteNode.value) {
            head.value = -1;
        }
        //删除的是尾结点，而且有多个结点
        else {
            LinkedNode node = head;
            while (node.next.value != toBeDeleteNode.value) {
                node = node.next;
            }

            node.next = null;
            toBeDeleteNode = null;
        }


    }

    static class LinkedNode {
        public LinkedNode(int value) {
            this.value = value;
        }

        int value;
        LinkedNode next;

    }

}
