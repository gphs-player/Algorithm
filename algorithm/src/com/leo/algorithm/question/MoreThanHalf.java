package com.leo.algorithm.question;

public class MoreThanHalf {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 3, 3, 2, 2, 5, 3, 5, 3, 6};
//        moreThanHalfNum(arr);
        moreThanHalfNumCount(arr);
    }

    private static void moreThanHalfNumCount(int[] arr) {
        int result = arr[0];
        int times = 1;

        for (int i = 1; i < arr.length; i++) {
            int item = arr[i];
            if (times == 0) {
                result = item;
                times = 1;
            } else if (item == result) {
                times++;
            } else {
                times--;
            }
        }
        System.out.println(result);
    }


    private static void moreThanHalfNum(int[] arr) {
        if (arr == null || arr.length <= 0) {
            System.out.println("Illegal params !!!");
            return;
        }

        int middle = arr.length >> 1;
        int start = 0;
        int end = arr.length - 1;

        int index = partition(arr, 0, arr.length - 1);

        while (index != middle) {
            if (index > middle) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(arr, start, end);

        }

        int result = arr[middle];
        boolean moreThanHalf = checkMoreThanHalf(arr, result);
        if (moreThanHalf) {
            System.out.println(result);
        } else {
            System.out.println("没有满足条件的数值");
        }
    }

    private static boolean checkMoreThanHalf(int[] arr, int result) {
        int times = 0;
        for (int indexValue : arr) {
            if (indexValue == result) {
                times++;
            }
        }
        if (times * 2 >= arr.length) {
            return true;
        }
        return false;
    }

    /**
     * 基于分治法找出中位数
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
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
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }
}
