### 构建二叉树

已知前序遍历和中序遍历的两个输出，构建二叉树

```
int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
```

#### 思路

前序遍历的第一个值就是根节点

中序遍历中找到根节点，那么根节点左边的值都属于左子树，右边的值都属于右子树。

然后重复上述步骤，找出各自的左右子树



#### Java实现

```java
private static BinaryTreeNode createTree(int[] pre, int[] in) {
    BinaryTreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    return root;
}

private static BinaryTreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
    if(preStart>preEnd || inStart > inEnd){ //到达边界条件时返回null
        return null;
    }
    BinaryTreeNode treeNode = new BinaryTreeNode();   //新建一个TreeNode
    treeNode.value = pre[preStart];

    for (int i = inStart; i <= inEnd; i++) {
        if (in[i] == pre[preStart]) {    //在中序中找到根节点的位置，【依次】将先序序列和中序序列分成左右字树，分别构建左右子树。
            // 重构左子树，注意边界条件
            treeNode.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
            // 重构右子树，注意边界条件
            treeNode.right = reConstructBinaryTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
        }
    }
    return treeNode;
}


static class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
}
```

#### C++实现

```C++
#include <iostream>

struct BinaryNode {
    int m_nValue;
    BinaryNode *left;
    BinaryNode *right;
};

BinaryNode *ConstructCore(int *startPreOrder, int *endPreOrder, int *startInOrder, int *endInOrder);

BinaryNode *Construct(int *preOrder, int *inOrder, int length) {
    if (preOrder == nullptr || inOrder == nullptr || length < 0) {
        return nullptr;
    }
    return ConstructCore(preOrder, preOrder + length - 1, inOrder, inOrder + length - 1);
}

BinaryNode *ConstructCore(int *startPreOrder, int *endPreOrder, int *startInOrder, int *endInOrder) {

    int rootValue = startPreOrder[0];
    BinaryNode *root = new BinaryNode();
    root->m_nValue = rootValue;
    root->left = nullptr;
    root->right = nullptr;

    if (startPreOrder == endPreOrder) {
        if (startInOrder == endInOrder && *startPreOrder == *startInOrder) {
            return root;
        } else {
            throw std::exception();
        }
    }

    //在中序遍历中找到根节点的值
    int *rootInOrder = startInOrder;
    while (rootInOrder < endInOrder && *rootInOrder != rootValue) {
        ++rootInOrder;
    }

    if (rootInOrder == endInOrder && *rootInOrder != rootValue) {
        throw std::exception();
    }

    int leftLength = rootInOrder - startInOrder;
    int *leftPreOrderEnd = startPreOrder + leftLength;

    if (leftLength > 0) {
        root->left = ConstructCore(startPreOrder + 1,leftPreOrderEnd,startInOrder,rootInOrder - 1);
    }
    if (leftLength < endPreOrder - startPreOrder) {
        root->right = ConstructCore(leftPreOrderEnd + 1,endPreOrder,rootInOrder + 1,endInOrder);
    }

    return root;
}
void print(BinaryNode * node){
    if (node->left != nullptr){
        print(node->left);
    }
    if (node->right != nullptr){
        print(node->right);
    }
    std::cout << node->m_nValue;
}

int main() {
    using namespace std;

    int  preOrder[] = {1,2,4,7,3,5,6,8};
    int inOrder[] = {4,7,2,1,5,3,8,6};
    BinaryNode * node = Construct(preOrder,inOrder,8);
    print(node);
    return 0;
}
```