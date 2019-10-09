package com.leo.structure.link;

/**
 * 链表操作
 */
public class MyLink {

    static class Node {
        private Node next;
        private int data;

        public Node(int data) {
            this.data = data;
        }
    }

    private int size;
    private Node head;
    private Node last;


    public void insert(int data, int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表范围");
        }
        Node node = new Node(data);

        if (size == 0) {
            //empty
            head = node;
            last = node;

        } else if (index == 0) {
            node.next = head;
            head = node;
        } else if (index == size) {
            last.next = node;
            last = node;
        } else {
            //中间插入
            Node preNode = get(index - 1);
            node.next = preNode.next;
            preNode.next = node;
        }
        size++;

    }

    private Node delete(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表范围");
        }
        Node removeNode = null;
        if (index == 0) {//删除头部结点
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {//删除尾部结点
            Node preNode = get(index - 1);
            removeNode = preNode.next;
            last = preNode;
            preNode.next = null;
        } else {
            Node node = get(index - 1);
            Node nextNode = node.next.next;
            removeNode = node.next;
            node.next = nextNode;
        }
        size--;
        return removeNode;
    }

    private Node get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表范围");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String [] args){
        MyLink myLink = new MyLink();
        myLink.insert(3,0);
        myLink.insert(7,1);
        myLink.insert(9,2);
        myLink.insert(5,3);
        myLink.insert(6,1);
        myLink.delete(0);
        myLink.output();
        // 6 7 9 5
    }
}
