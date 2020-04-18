### 二叉搜索树转有序双向链表

<pre>
             10
           /    \
          6      14
         / \     / \
        4   8   12  16 
</pre>

上面的二叉树，转为有序的双向链表结构是[4,6,8,10,12,14,16]

要求不能新建结点，只能调整顺序

#### 思路

我们可以中序遍历树中的每一个结点，这是因为中序遍历算法的特点是按照从小到大的顺序遍历二叉树的每一个结点。当遍历到根结点的时候，我们把树看成三部分：值为10的结点、根结点值为6的左子树、根结点值为14的右子树。根据排序链表的定义，值为10的结点将和它的左子树的最大一个结点（即值为8的结点）链接起来，同时它还将和右子树最小的结点（即值为12的结点）链接起来

按照中序遍历的顺序，当我们遍历转换到根结点（值为10的结点）时，它的左子树已经转换成一个排序的链表了，并且处在链表中的最后一个结点是当前值最大的结点。我们把值为8的结点和根结点链接起来，此时链表中的最后一个结点就是10了。接着我们去遍历转换右子树，并把根结点和右子树中最小的结点链接起来。至于怎么去转换它的左子树和右子树，由于遍历和转换过程是一样的，我们很自然地想到可以用递归。

#### 代码

```java
public class ConvertTreeToLink {
    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(14);

        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(8);

        root.right.left = new BinaryTreeNode(12);
        root.right.right = new BinaryTreeNode(16);


        BinaryTreeNode result = null;
        BinaryTreeNode binaryTreeNode = convertTree(root, result);
        while (binaryTreeNode != null && binaryTreeNode.left != null) {
            binaryTreeNode = binaryTreeNode.left;
        }
        System.out.println(binaryTreeNode);
    }

    private static BinaryTreeNode convertTree(BinaryTreeNode root, BinaryTreeNode result) {
        if (root == null) return null;
        BinaryTreeNode curNode = root;
        if (curNode.left != null) {
            result = convertTree(curNode.left, result);
        }
        curNode.left = result;

        if (result != null) {
            result.right = curNode;
        }

        result = curNode;
        if (curNode.right != null) {
            result = convertTree(curNode.right, result);
        }
        return result;
    }
}
```