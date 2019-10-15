package com.leo.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序算法
 */
public class BubbleSort {

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
//        bubbleSort(arr);
//        bubbleSort2(arr);
        int[] arr3 = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        bubbleSort3(arr3);
//        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                count++;
                int temp;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
                /*
                [5, 6, 3, 8, 2, 1, 7, 9]
                [5, 3, 6, 2, 1, 7, 8, 9]
                [3, 5, 2, 1, 6, 7, 8, 9]
                [3, 2, 1, 5, 6, 7, 8, 9]
                [2, 1, 3, 5, 6, 7, 8, 9]
                [1, 2, 3, 5, 6, 7, 8, 9]
                [1, 2, 3, 5, 6, 7, 8, 9]//最后一轮是不必要的，因为已经有序了
                */
        }
        System.out.println(count);
    }

    /**
     * 如果排序到最后若干轮，列表已经有序，如何优化？
     */
    private static void bubbleSort2(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean sorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                int temp;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sorted = false;//如果本轮循环有元素交换，说明无序，否则就是有序了，跳出大循环
                }
            }
            if (sorted) {//避免不必要排序
                break;
            }
            System.out.println(Arrays.toString(arr));
            /*
            [5, 6, 3, 8, 2, 1, 7, 9]
            [5, 3, 6, 2, 1, 7, 8, 9]
            [3, 5, 2, 1, 6, 7, 8, 9]
            [3, 2, 1, 5, 6, 7, 8, 9]
            [2, 1, 3, 5, 6, 7, 8, 9]
            [1, 2, 3, 5, 6, 7, 8, 9]//减少一轮循环
            * */
        }
    }


    /**
     * 如果数组的后半段是有序的，怎么避免每次循环都进行无用的比较
     */
    private static void bubbleSort3(int arr[]) {
        int count = 0;
        int lastExchangeIndex = 0;
        int sortBorder = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean sorted = true;
            for (int j = 0; j < sortBorder; j++) {
                count++;
                int temp;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sorted = false;//如果本轮循环有元素交换，说明无序，否则就是有序了，跳出大循环
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (sorted) {//避免不必要排序
                break;
            }
            System.out.println(Arrays.toString(arr));
            /* 仅比较10次就能得出结果，如果用前两次的方法，要比较28次
            [3, 2, 1, 4, 5, 6, 7, 8]
            [2, 1, 3, 4, 5, 6, 7, 8]
            [1, 2, 3, 4, 5, 6, 7, 8]
            * */
        }
        System.out.println(count);
    }
}
