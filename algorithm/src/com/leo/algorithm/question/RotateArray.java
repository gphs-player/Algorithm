package com.leo.algorithm.question;

/**
 * 旋转数组的最小数字
 * <p>
 * 34512就是12345的旋转
 * <p>
 * 最小值就是1
 * <p>
 * 利用二分法来解决
 * <p>
 * 如果是在排序的数组中寻找某个数字都可以尝试二分法
 */
public class RotateArray {


    public static void main(String[] args) {
        //相对有序的数组
        int [] arr1 = {3,4,5,1,2};
        int [] arr2 = {1,1,1,0,1};
        System.out.println(min(arr2,arr2.length));
    }


    private static int min(int[] arr, int length) {
        if (arr == null || arr.length == 0) throw new IllegalStateException("Invalid args !!!");
        int start = 0;
        int end = length - 1;
        int mid = start;//如果旋转数组已经是有序的，那么第一个值就应该是返回值，所以先把mid指向start
        //选定两个指针指向数组的首位和末位
        //分别和数组中间的值做比较
        //如果中间值大于首位，说明中间值处于第一部分递增数组，否则属于第二部分递增数组
        //然后将首位和末位的索引更改，缩小范围重复上述步骤
        while (arr[start] >= arr[end]) {//要考虑数据重复的情况
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end)/2;


            if (arr[start] == arr[end] && arr[mid] == arr[start]){
                //数据重复，中间值等于首尾值，这个时候需要寻找合适的位置
                return minOrder(arr,start,end);
            }

            if (arr[mid] > arr[start]){
                start = mid;
            }else if (arr[mid] <= arr[end]){
                end = mid;
            }
        }

        return arr[mid];
    }

    private static int minOrder(int[] arr, int start, int end) {
        int result = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (result > arr[i]){
                result = arr[i];
            }
        }
        return result;
    }


}
