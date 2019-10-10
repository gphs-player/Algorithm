package com.leo.structure.tree;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 遍历二叉树
 */
public class TraverseTree {

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(
                Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));

        /*   构建树
        *            3
        *           / \
        *          2   8
        *         / \   \
        *        9  10   4
        *
        */
        TreeNode treeNode = createBinaryTree(inputList);

        preOderTraversal(treeNode);
        System.out.println();
        inOderTraversal(treeNode);
        System.out.println();
        postOderTraversal(treeNode);
        System.out.println();
        traversal(treeNode);
        System.out.println();
        layerTraversal(treeNode);

    }

    /**
     * 创建一棵二叉树
     */
    private static TreeNode createBinaryTree(LinkedList<Integer> list) {

        if (list == null || list.isEmpty()) return null;

        TreeNode node = null;

        Integer data = list.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(list);
            node.rightChild = createBinaryTree(list);
        }
        return node;
    }

    /**
     * 前序遍历
     */
    private static void preOderTraversal(TreeNode node) {
        //根 左 右
        if (node == null) return;
        System.out.println(node.data);
        preOderTraversal(node.leftChild);
        preOderTraversal(node.rightChild);
    }


    /**
     * 中序遍历
     */
    private static void inOderTraversal(TreeNode node) {
        // 左 根 右
        if (node == null) return;
        inOderTraversal(node.leftChild);
        System.out.println(node.data);
        inOderTraversal(node.rightChild);
    }

    /**
     * 后序遍历
     */
    private static void postOderTraversal(TreeNode node) {
        // 左 根 右
        if (node == null) return;
        postOderTraversal(node.leftChild);
        postOderTraversal(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 非递归遍历二叉树
     */
    private static void traversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode treeNode = root;

        while (treeNode != null || !stack.isEmpty()) {
            //访问左孩子，入栈
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 层序遍历，按层遍历,借助队列
     */
    private static void layerTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild!=null){
                queue.offer(node.leftChild);
            }
            if (node.rightChild!=null){
                queue.offer(node.rightChild);
            }
        }
    }


    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }
}
