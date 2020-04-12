package com.leo.algorithm.question;

/**
 * 判断树B是不是树A的子树结构
 */
public class IsSubTree {

    public static void main(String[] args) {
        BinaryTreeNode rootA = new BinaryTreeNode(8);
        rootA.left = new BinaryTreeNode(8);
        rootA.right = new BinaryTreeNode(7);

        rootA.left.left = new BinaryTreeNode(9);
        rootA.left.right = new BinaryTreeNode(2);

        rootA.left.right.left = new BinaryTreeNode(4);
        rootA.left.right.right = new BinaryTreeNode(7);


        BinaryTreeNode rootB = new BinaryTreeNode(8);
        rootB.left = new BinaryTreeNode(9);
        rootB.right = new BinaryTreeNode(2);


        System.out.println(isSubtree(rootA, rootB));
    }

    private static boolean isSubtree(BinaryTreeNode rootA, BinaryTreeNode rootB) {

        boolean result = false;
        if (rootA != null && rootB != null) {

            if (rootA.value == rootB.value) {

                result = containsTree(rootA, rootB);
            }

            if (!result) {
                result = isSubtree(rootA.left, rootB);
            }
            if (!result) {
                result = isSubtree(rootA.right, rootB);
            }
        }

        return result;
    }

    private static boolean containsTree(BinaryTreeNode rootA, BinaryTreeNode rootB) {
        boolean result;
        if (rootB == null) return true;
        if (rootA == null) return false;
        if (rootA.value != rootB.value) {
            return false;
        }

        return containsTree(rootA.left, rootB.left) & containsTree(rootA.right, rootB.right);
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
