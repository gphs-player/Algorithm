### 找到链表倒数第K个节点



#### 思路

先后指针，第一个指针先走K-1步，第二个指针再出发，当第一个指针到达末尾的时候，第二个指针就是结果。

#### 注意点

* 给出的链表为空怎么办
* K值大于链表数量怎么办
* K=0怎么处理

#### 代码

```java
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
```



#### 扩展

* 如果链表的结点总数返回中间结点，如果是偶数返回中间两个的任意一个

* 判断链表有环

以上两个问题都可以用快慢指针实现，第一个指针每次走两步，第二个指针每次一步，当第一个指针到达末尾的时候，第二个指针就在中间。当第一个指针追上了第一个指针，那么证明链表有环。