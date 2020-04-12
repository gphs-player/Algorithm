### O(1)的时间删除链表结点

`deleteNode(Node head, Node tobeDelete)`

给定链表，和要删除的结点

#### 分析

因为只拿到了要删除的结点P，所以要把P结点的next赋值给P的前驱pre,但是单向链表没有pre的指针，因此需要循环遍历判断。但是这种方法的时间复杂度是O(n).

更简单的思路是，将P的next结点的值赋值给P，P的next再指向P的next的next。等于将下一个结点的值复制到当前结点，也相当于删除了P结点。

除此之外要考虑两种边界情况

* 链表只有一个结点
* 删除的是尾部结点

如果链表只有一个结点，直接删除即可。

但是如果是尾部结点要删除，那么也只能通过遍历的手段取到pre结点。

```java
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
```