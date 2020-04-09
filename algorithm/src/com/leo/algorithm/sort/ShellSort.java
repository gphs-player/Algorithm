package com.leo.algorithm.sort;


import java.util.Arrays;

public class ShellSort<AnyType extends Comparable<? super AnyType>> {
    public static void main(String[] args) {
        Integer[] datas = {5, 8, 1, 4, 9, 3, 2, 7, 6};
//        System.out.println(Arrays.toString(datas));
        sort(datas);
        System.out.println(Arrays.toString(datas));
    }


    public static <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] list) {
        int j;
        for (int gap = list.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < list.length; i++) {
                AnyType tmp = list[i];
                for (j = i; j >= gap && tmp.compareTo(list[j - gap]) < 0; j -= gap) {
                    list[j] = list[j-gap];
                }
                list[j] = tmp;
            }
        }
    }
}
