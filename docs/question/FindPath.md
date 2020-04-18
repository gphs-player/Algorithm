### 二叉树路径查找

#### 思路

<pre>
            10
          /    \
         5     12
        / \    
       3   7 
</pre>

上面的二叉树，寻找和为22的所有路径结点就是【10-5-7】和【10-12】

首先要保存的是根节点的值，然后再去遍历子节点，比如[10-5]，然后计算两个数值的和，不满足条件就继续遍历结点[5]的子节点，整个路径就是[10-5-3],3已经没有子节点了，整条路径已经结束，还是不满足条件，就将结点3从我们的遍历路径中取出，将5的右节点7添加到遍历路径。依次执行。

所以整个的思路应该是前序遍历+栈结构+递归的方式去实现。

#### 代码

```java
public static void main(String[] args) {

    BinaryTreeNode root = new BinaryTreeNode(10);
    root.left = new BinaryTreeNode(5);
    root.right = new BinaryTreeNode(12);

    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(7);

    findPath(root, 22);
}

private static void findPath(BinaryTreeNode root, int targetSum) {
    if (root == null) return;
    Stack<BinaryTreeNode> stack = new Stack<>();
    findReal(root, targetSum, stack);

}

private static void findReal(BinaryTreeNode root, int targetSum, Stack<BinaryTreeNode> stack) {
    //将当前结点添加到栈
    stack.push(root);
    int curSum = 0;
    for (int i = 0; i < stack.size(); i++) {
        curSum += stack.get(i).value;
    }
    
    //判断是否满足条件
    boolean isLeaf = root.left == null && root.right == null;
    if (curSum == targetSum && isLeaf) {
        System.out.println("找到一条路径");
        System.out.print("Path: ");
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i).value + " ");
        }
        System.out.println();
    }

    //不满足条件继续添加子节点
    if (root.left != null) {
        findReal(root.left, targetSum, stack);
    }

    if (root.right != null) {
        findReal(root.right, targetSum, stack);
    }
    //已经是叶子结点，回溯到根节点
    stack.pop();

}
```