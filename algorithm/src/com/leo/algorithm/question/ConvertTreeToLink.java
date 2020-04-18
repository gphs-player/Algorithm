package com.leo.algorithm.question;

/**
 * 将二叉搜索树转换为有序的双向链表
 */
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
