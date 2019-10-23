package com.leo.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * 桶排序
 * 解决计数排序的不足点
 */
public class BucketSort {
    public static void main(String [] args){
        double[] array = {4.12, 6.421, 0.0023, 3.0, 2, 123, 8, 122, 4, 12};
        double[] sort = bucketSort(array);
        System.out.println(Arrays.toString(sort));
    }

    private static double[] bucketSort(double [] arr){
        double max = arr[0];
        double min = arr[0];


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
        }
        //
        double d = max - min;



        //初始化桶

        int bucketNum = arr.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);

        double step = d/(bucketNum - 1);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }
        //遍历原始数组 将元素放入桶中
        //区间跨度=（最大值-最小值）/(桶的数量-1)
        for (int i = 0; i < arr.length; i++) {
            int num = (int) ((arr[i] - min) / step);
            bucketList.get(num).add(arr[i]);
        }

        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }
        double [] sortedArray = new double[arr.length];

        int index = 0;

        for (LinkedList<Double> list : bucketList) {
            for (Double aDouble : list) {
                sortedArray[index] = aDouble;
                index ++;
            }
        }
        return sortedArray;

    }

}
