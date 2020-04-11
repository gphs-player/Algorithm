package com.leo.algorithm.question;

import java.util.Stack;

public class ReverseLink {


    public static void main(String[] args) {


        ListNode link = createLink();

        reverse(link);
        System.out.println("-----");
        reverseRecursive(link);

    }

    /**
     * 借助栈实现
     */
    private static void reverse(ListNode link) {
        if (link == null) return;
        Stack<ListNode> ls = new Stack<>();
        ListNode node = link;
        while (node != null) {
            ls.push(node);
            node = node.next;
        }
        while (!ls.empty()) {
            ListNode pop = ls.pop();
            System.out.println(pop);
        }
    }


    private static void reverseRecursive(ListNode link) {
        if (link == null) throw new NullPointerException("reverseRecursive::: param can not be null !!!");
        if (link.next != null) {
            reverseRecursive(link.next);
        }
        System.out.println(link);
    }


    private static ListNode createLink() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }


    static class ListNode {
        public ListNode(int value) {
            this.value = value;
        }

        int value;
        ListNode next;

        @Override
        public String toString() {
            return "value=" + value;
        }
    }
}
