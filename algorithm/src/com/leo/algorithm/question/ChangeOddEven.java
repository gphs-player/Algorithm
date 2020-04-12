package com.leo.algorithm.question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 * 交换奇偶数
 */
public class ChangeOddEven {

    public static void main(String[] args) {
        int[] arr = {1, -1, 2, 3, 4, -6, -8, -2, 5, 6, 7, 8, 9, 10,- 3};
        changeOddEven(arr, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
//                return (integer & 0x1) == 0;
                return integer > 0;
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    private static void changeOddEven(int[] arr, Predicate<Integer> isEven) {
        if (arr == null || arr.length == 0) return;
        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex < endIndex) {
            //指向第一个偶数
            while (startIndex < endIndex && !isEven.test(arr[startIndex])) {
                startIndex++;
            }
            //指向最后的奇数
            while (startIndex < endIndex && isEven.test(arr[endIndex])) {
                endIndex--;
            }

            if (startIndex < endIndex) {
                int tmp = arr[startIndex];
                arr[startIndex] = arr[endIndex];
                arr[endIndex] = tmp;
            }
        }
    }
}
