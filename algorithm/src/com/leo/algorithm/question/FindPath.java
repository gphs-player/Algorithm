package com.leo.algorithm.question;

import java.util.Stack;

/**
 * 寻找二叉树中  和为某个数字结点路径
 */
public class FindPath {


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
}
