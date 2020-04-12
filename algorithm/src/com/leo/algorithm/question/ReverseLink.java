package com.leo.algorithm.question;


import static com.leo.algorithm.question.DeleteLinkedNode.LinkedNode;

/**
 * 反转链表，不是倒序输出，而是链表的指针全部反向指引
 */
public class ReverseLink {


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

        System.out.println(reverse(head).value);
    }

    private static LinkedNode reverse(LinkedNode node) {

        if (node == null) return null;

        LinkedNode reverseHead = null;
        LinkedNode mCur = node;
        LinkedNode pre = null;

        while (mCur != null) {
            LinkedNode nextNode = mCur.next;
            if (nextNode == null){
                //这个时候反转链表的头结点就找到了
                reverseHead = mCur;
            }
            mCur.next = pre;
            pre = mCur;
            mCur = nextNode;
        }
        return reverseHead;
    }


}
