package com.leo.structure.tree;

import java.util.Arrays;

/**
 * 二叉堆的操作
 */
public class MyHead {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 9, 10, 0};
        upAdjust(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{7, 1, 3, 10, 5, 2, 9, 6};
        buildHead(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param array 上浮操作
     */
    private static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        //数组中父子节点的关系是
        //左孩子 2*parent +1
        //右孩子 2*parent +2
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            //单向赋值交换，因为父节点还是和temp比较
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * @param array       下沉操作
     * @param parentIndex 要下沉的节点
     */
    private static void downAdjust(int[] array, int parentIndex) {
        int length = array.length;
        //要下沉的父节点
        int temp = array[parentIndex];
        //左孩子
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            //如果存在右孩子，并且右孩子大于左孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            //父节点小于孩子节点，跳出
            if (temp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }

    private static void buildHead(int[] arr) {

        //从最后一个非叶子节点开始，依次下沉
        for (int i = (arr.length - 2) / 2; i > 0; i--) {
            downAdjust(arr, i);
        }


    }
}
