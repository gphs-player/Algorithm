### 反转链表

首先构造一个链表

```java
private static ListNode createLink() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5)
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
```

#### 栈实现

```java
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
```

#### 递归实现

还可以使用递归的方式实现，本质上也是使用栈来实现的。但是链表过长的时候会有栈溢出的风险，不如用栈来显示调用

```java
private static void reverseRecursive(ListNode link) {
    if (link == null) throw new NullPointerException("reverseRecursive::: param can not be null !!!");
    if (link.next != null) {
        reverseRecursive(link.next);
    }
    System.out.println(link);
}
```

