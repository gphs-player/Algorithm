package com.leo.algorithm.sort;


import java.util.Arrays;

/**
 * 从第一个元素开始直至第N项
 * 第j项排序要保证前j+1项是有序的
 */
public class InsertionSort<AnyType extends Comparable<AnyType>> {


    public static <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] list) {
        int p;
        for (p = 1; p < list.length; p++) {
            AnyType tmp = list[p];
            int j;
            //临时值要一直和索引之前所有的值比较
            for (j = p; j > 0 && tmp.compareTo(list[j - 1]) > 0; j--) {
                list[j] = list[j - 1];
            }

            list[j] = tmp;
            System.err.println(Arrays.toString(list));
        }
    }


    public static void main(String[] args) {
        Integer[] datas = {5, 8, 1, 4, 9, 3, 2, 7, 6};
//        System.out.println(Arrays.toString(datas));
        sort(datas);
        System.out.println(Arrays.toString(datas));
    }
}
