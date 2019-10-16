package com.leo.algorithm.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序
 * 分治法
 * 平均时间复杂度O(㏒n)
 * 最坏情况O(n²)
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
//        quickSortDouble(arr, 0, arr.length - 1);
//        quickSortSingle(arr, 0, arr.length - 1);
        quickSortStack(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSortDouble(int[] arr, int startIndex, int endIndex) {
        //递归条件结束，startIndex大于等于endIndex
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partitionDouble(arr, startIndex, endIndex);
        quickSortDouble(arr, startIndex, pivotIndex - 1);
        quickSortDouble(arr, pivotIndex + 1, endIndex);
    }

    //quickSortDouble(arr,0,2)
    //--quickSortDouble(arr,0,1)
    //--quickSortDouble(arr,3,3)忽略


    //quickSortDouble(arr,4,7)
    //--quickSortDouble(arr,4,3)
    //--quickSortDouble(arr,5,7)
    //----quickSortDouble(arr,5,4)
    //----quickSortDouble(arr,6,7)

    /**
     * 双边循环法
     */
    private static int partitionDouble(int[] arr, int startIndex, int endIndex) {

        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            //控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
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


    /**
     * 单边循环
     */
    private static void quickSortSingle(int arr[], int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partitionSingle(arr, startIndex, endIndex);
        quickSortSingle(arr, startIndex, pivotIndex - 1);
        quickSortSingle(arr, pivotIndex + 1, endIndex);

    }

    private static int partitionSingle(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        //每轮循环结束后，交换mark位置元素和pivot的基准值
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;

        return mark;
    }


    /**
     * 非递归实现
     */
    private static void quickSortStack(int arr[], int startIndex, int endIndex) {

        Stack<Map<String, Integer>> quickSortStack = new Stack<>();

        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);

        quickSortStack.push(rootParam);

        while (!quickSortStack.isEmpty()) {
            Map<String, Integer> param = quickSortStack.pop();

            int piviot = partitionSingle(arr, param.get("startIndex"), param.get("endIndex"));

            if (param.get("startIndex") < piviot - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex",param.get("startIndex"));
                leftParam.put("endIndex",piviot - 1);
                quickSortStack.push(leftParam);
            }
            if (piviot + 1 < param.get("endIndex")){
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex",piviot + 1);
                rightParam.put("endIndex",param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }
}
