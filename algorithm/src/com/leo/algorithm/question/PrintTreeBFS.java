package com.leo.algorithm.question;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 广度优先遍历二叉树
 * 从上到下打印二叉树
 * <p>
 * <p>
 * <pre>
 * 8
 * /   \
 * 6      10
 * / \    / \
 * 5   3  2   7
 * </pre>
 */

public class PrintTreeBFS {

    public static void main(String[] args) {
        TreeNode tree = createBinaryTree();
        printTreeBDF(tree);

    }

    private static void printTreeBDF(TreeNode tree) {
        if (tree == null) return;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            TreeNode head = queue.pollFirst();
            System.out.println(head.value);
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }

    private static TreeNode createBinaryTree() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(7);
        return root;
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
        public TreeNode() {
        }
    }
}
