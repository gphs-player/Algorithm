package com.leo.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 分治法
 * 平均时间复杂度O(㏒n)
 * 最坏情况O(n²)
 */
public class QuickSort {
    public static void main(String[] args) {
        int []arr = new int[]{4,7,6,5,3,2,8,1};
        quickSort(arr,0,arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        //递归条件结束，startIndex大于等于endIndex
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition(arr,startIndex,endIndex);
        quickSort(arr, startIndex, pivotIndex -1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {

        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            //控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left ++;
            }
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        System.out.println(left);
        return left;
    }
}
