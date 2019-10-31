package com.leo.algorithm.question;

import java.util.Arrays;

/**
 *  找到缺失的数字
 */
public class FindLostNum {

    public static void main(String [] args){
        System.out.println(1<<1<<1);
        int [] arr = {4,1,2,2,5,1,4,3};
        System.out.println(Arrays.toString(findLostNums(arr)));
    }

    private static int [] findLostNums(int [] array){
        //用于存储结果
        int result[] = new int[2];
        int xorResult = 0;
        for (int i = 0; i < array.length; i++) {
            xorResult ^= array[i];
        }
        //如果所有数字运算结果是0，说明题目不符合要求
        if (xorResult == 0){
            return null;
        }

        //确定2个整数的不同位，以此分组
        int separator =1;
        while ( 0 == (xorResult&separator)){
            separator<<=1;
        }
        for (int i = 0; i < array.length; i++) {
            //两个数被分为两个组，每个组的异或运算值的最终结果都是求的数
            if (0 == (array[i]&separator)){
                result[0]^=array[i];
            }else {
                result[1]^=array[i];
            }
        }
        return result;
    }
}
