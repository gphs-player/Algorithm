### 镜像二叉树



```java
/**
 * <pre>
 * 二叉树的镜像
 * 如下
 *      6               6
 *   8    10        10     8
 * 2  3  7  5     5   7   3  2
 *
 * 第一步交换 根节点的左右子节点,只交换第一层结点。
 *      6               6
 *   8    10        10     8
 * 2  3  7  5     7   5   2  3
 *
 * 第二步，往下遍历左右子节点，如果不为空，继续交换。
 *
 *       6              6
 *   10     8       10     8
 * 7   5   2  3   5   7   3  2
 * </pre>
 */
public class MirrorBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode rootOrigin = new BinaryTreeNode(6);
        rootOrigin.left = new BinaryTreeNode(8);
        rootOrigin.right = new BinaryTreeNode(10);

        rootOrigin.left.left = new BinaryTreeNode(2);
        rootOrigin.left.right = new BinaryTreeNode(3);

        rootOrigin.right.left = new BinaryTreeNode(7);
        rootOrigin.right.right = new BinaryTreeNode(5);

        printTreePre(rootOrigin);
        mirrorTree(rootOrigin);
        System.out.println();
        printTreePre(rootOrigin);
    }
		//前序遍历二叉树
    private static void printTreePre(BinaryTreeNode rootOrigin) {
        if (rootOrigin == null)return;
        System.out.println(rootOrigin.value);
        if (rootOrigin.left != null){
            printTreePre(rootOrigin.left);
        }
        if (rootOrigin.right!= null){
            printTreePre(rootOrigin.right);
        }
    }

    private static BinaryTreeNode mirrorTree(BinaryTreeNode rootOrigin) {
        if (rootOrigin == null) return null;
        if (rootOrigin.left == null && rootOrigin.right == null) return rootOrigin;
        BinaryTreeNode tmp = rootOrigin.left;
        rootOrigin.left = rootOrigin.right;
        rootOrigin.right = tmp;
        if (rootOrigin.left != null) {
            mirrorTree(rootOrigin.left);
        }
        if (rootOrigin.right != null) {
            mirrorTree(rootOrigin.right);
        }
        return rootOrigin;
    }

    static class BinaryTreeNode {
        int value;
        public BinaryTreeNode(int value) {
            this.value = value;
        }
        public BinaryTreeNode() {
        }
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
}
```