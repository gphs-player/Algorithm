package com.leo.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 不稳定排序
 * 最大堆的堆顶是最大元素
 * 最小堆的堆顶是最小元素
 *
 * 空间复杂度O(1),没有开辟额外的空间
 *
 * "下沉"调整是算法的基础，O(log n)
 *
 *
 * 1.把数组构建称为二叉堆，时间复杂度O(n)
 *
 * 2.循环删除并下沉调整堆顶，O(nlogn)
 *
 * 因为二者是并列关系，整体时间复杂度是O(nlogn)，
 *
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 9, 4, 7, 2, 6};
        headSort(arr);
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
        for (int i = arr.length - 1; i >0 ; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            downAdjust(arr,0,i);
        }
    }
}
