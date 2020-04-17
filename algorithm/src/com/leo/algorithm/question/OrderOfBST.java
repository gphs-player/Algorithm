package com.leo.algorithm.question;

/**
 * 二叉搜索树的后续遍历序列
 */
public class OrderOfBST {


    public static void main(String[] args) {
        int arr[] = {5,7,6,9,11,10,8};

        System.out.println(checkOrder(arr, arr.length));
    }

    private static boolean checkOrder(int[] arr, int length) {
        if (arr == null || length == 0) return false;
        int root = arr[length - 1];
        int rightStart = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] > root) {
                rightStart = i;
                break;
            }
        }

        for (int j = rightStart; j < length - 1; j++) {// 除去根节点的值
            if (arr[j] < root) {
                return false;//存在比根节点小的值，不满足条件
            }
        }


        boolean left = true;
        if (rightStart > 0) {
            left = checkOrder(arr, rightStart);
        }

        boolean right = true;
        if (rightStart > 0) {
            right = checkOrder(arr, length - rightStart - 1);
        }

        return left && right;
    }
}
