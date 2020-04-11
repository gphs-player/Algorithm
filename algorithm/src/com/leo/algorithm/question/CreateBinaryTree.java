package com.leo.algorithm.question;

import java.util.Arrays;

public class CreateBinaryTree {


    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode tree = createTree(pre, in);
        afterPrint(tree);
        System.out.println("+++++");
        prePrint(tree);
    }



    private static void afterPrint(BinaryTreeNode tree) {
        if (tree.left != null) {
            afterPrint(tree.left);
        }
        if (tree.right != null) {
            afterPrint(tree.right);
        }
        System.out.println(tree.value);
    }


    private static void prePrint(BinaryTreeNode tree) {
        System.out.println(tree.value);
        if (tree.left != null) {
            prePrint(tree.left);
        }
        if (tree.right != null) {
            prePrint(tree.right);
        }
    }


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

}
