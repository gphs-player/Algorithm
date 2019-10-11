package com.leo.algorithm.sort;

import java.util.Arrays;

/**
 * 鸡尾酒排序
 * 冒泡排序的优化
 * <p>
 * 在数组序列大部分有序的情况下，冒泡排序似乎有点憋屈。
 * 比如【2，3，4，5，6，7，8，1】
 * 应用场景也是比较特殊的
 * <p>
 * 思路：第一轮从左往右排序，第二轮从右往左排序，第三轮从左往右排序...
 * 类似钟摆，从两端排序
 */
public class CocktailSort {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 1};
        sort(arr);

    }

    private static void sort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length / 2; i++) {
            boolean sorted = true;
            //从左往右排序
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sorted = false;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (sorted) break;
            //从右往左排序之前，重置sorted
            sorted = true;
            //从右往左
            for (int j = arr.length - i - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    sorted = false;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (sorted) break;
        }
        //按照鸡尾酒排序思路，只需三次便可得到结果，最后一次排序为算法需要
/*
[2, 3, 4, 5, 6, 7, 1, 8]
[1, 2, 3, 4, 5, 6, 7, 8]
[1, 2, 3, 4, 5, 6, 7, 8]
*/
    }
}
