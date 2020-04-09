package com.leo.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 不稳定排序
 * 最大堆的堆顶是最大元素
 * 最小堆的堆顶是最小元素
 * <p>
 * 空间复杂度O(1),没有开辟额外的空间
 * <p>
 * "下沉"调整是算法的基础，O(log n)
 * <p>
 * <p>
 * 1.把数组构建称为二叉堆，时间复杂度O(n)
 * <p>
 * 2.循环删除并下沉调整堆顶，O(nlogn)
 * <p>
 * 因为二者是并列关系，整体时间复杂度是O(nlogn)，
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 5, 9, 4, 3, 7, 2, 6};
//        headSort(arr);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static void downAdjust(int[] arr, int parentIndex, int length) {

        int temp = arr[parentIndex];
        //左孩子
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            //如果有右孩子,并且大于左孩子，定位到右孩子
            if (childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex]) {
                childIndex++;
            }
            //如果父节点大于任何一个孩子，则直接跳出
            if (temp > arr[childIndex]) {
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        arr[parentIndex] = temp;
    }

    /**
     * 堆排序  升序
     */
    private static void headSort(int arr[]) {
        //从最后一个结点开始，构建最大堆 O(n)
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            downAdjust(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));

        //循环删除堆顶元素，移动到集合尾部，再调整堆顺序 O(nlogn)
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            downAdjust(arr, 0, i);
        }
    }


    private static void perDown(int[] arr, int i, int n) {
        int child;
        int tmp;
        for (tmp = arr[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && arr[child] < arr[child + 1]) {
                child++;
            }
            if (tmp < arr[child]) {
                arr[i] = arr[child];
            } else {
                break;
            }
        }
        arr[i] = tmp;
    }

    /**
     * 返回左孩子节点的索引
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    public static void heapSort(int[] arr) {
        //首先构建一个堆，
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            perDown(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            perDown(arr, 0, i);
        }
    }

}
