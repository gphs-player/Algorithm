### 判断序列是不是满足某个二叉搜索树的后序遍历序列

<pre>
			8
          /  \
         6    10
        / \   / \
       5   7 9  11
</pre>

序列[5，7，6，9，11，10，8]对应的二叉树，则该序列是满足后序遍历要求的。



#### 思路

一个后续遍历的序列，最后一个值就是根节点。剩下的序列分为两个部分，左子树的序列都小于根节点，右子树的序列都大于根节点。

比如[5，7，6，9，11，10，8]，根节点的值是8，[5，7，6]就是左子树的区域，[9，11，10]就是右子树的区域。

利用这样的思路，再将左子树和右子树分别进行子树结构的确定。如[5，7，6]，根节点就是6，5是左子树，7是右子树。

再看[7,4,6,5]序列，5是根节点，7大于5，因此位于7后面的数字都属于右子树，因为4小于5，所以不满足二叉搜索树的定义。



#### 代码

```java
public static void main(String[] args) {
    int arr[] = {5,7,6,9,11,10,8};
    System.out.println(checkOrder(arr, arr.length));
}

private static boolean checkOrder(int[] arr, int length) {
    if (arr == null || length == 0) return false;
    int root = arr[length - 1];
    int rightStart = 0;
    for (int i = 0; i < length; i++) {
        if (arr[i] > root) {
            rightStart = i;
            break;
        }
    }

    for (int j = rightStart; j < length - 1; j++) {// 除去根节点的值
        if (arr[j] < root) {
            return false;//存在比根节点小的值，不满足条件
        }
    }

    boolean left = true;
    if (rightStart > 0) {
        left = checkOrder(arr, rightStart);
    }

    boolean right = true;
    if (rightStart > 0) {
        right = checkOrder(arr, length - rightStart - 1);
    }

    return left && right;
}
```