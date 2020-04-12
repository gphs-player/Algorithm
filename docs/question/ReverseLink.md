### 反转链表

#### 思路

防止指针断裂，需要三个指针分别指向next/pre/cur

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
        //反向链接
        mCur.next = pre;
        //指针的后移
	      pre = mCur;
        mCur = nextNode;
    }
    return reverseHead;
}
```