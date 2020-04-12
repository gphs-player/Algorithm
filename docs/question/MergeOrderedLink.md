### 合并两个有序的数组

#### 思路

选取两个链表的头结点，较小值就是新链表的头结点，继续合并两个链表中剩余的结点。在两个链表中剩下的结点依然是排序的，因此合并这两个链表的步骤和前面的步骤是一样的。我们还是比较两个头结点的值。

当我们得到两个链表中值较小的头结点并把它链接到已经合并的链表之后，两个链表剩余的结点依然是排序的，因此合并的步骤和之前的步骤是一样的。这就是典型的递归的过程，我们可以定义递归函数完成这一合并过程。 

#### 代码

```java
public static void main(String[] args) {

    LinkedNode odd = new LinkedNode(1);
    odd.next = new LinkedNode(3);
    odd.next.next = new LinkedNode(5);
    odd.next.next.next = new LinkedNode(7);
  
    LinkedNode even = new LinkedNode(2);
    even.next = new LinkedNode(4);
    even.next.next = new LinkedNode(6);
    even.next.next.next = new LinkedNode(8);
    LinkedNode merge = merge(odd, even);
    while (merge!=null){
        System.out.println(merge.value);
        merge = merge.next;
    }
}

private static LinkedNode merge(LinkedNode odd, LinkedNode even) {
    if (odd == null) return even;
    if (even == null) return odd;
    LinkedNode newLink;
    if (odd.value < even.value){
        newLink = new LinkedNode(odd.value);
        newLink.next = merge(odd.next,even);
    }else {
        newLink = new LinkedNode(even.value);
        newLink.next = merge(odd,even.next);
    }
    return newLink;
}
```