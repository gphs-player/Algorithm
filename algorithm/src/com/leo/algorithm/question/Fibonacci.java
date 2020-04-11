package com.leo.algorithm.question;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 斐波那契数列
 * 0 (n=0)
 * f(n) =  1 (n=1)
 * f(n-1) + f(n-2) n > 1
 */
public class Fibonacci {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
//            System.out.println(fibonacci1(i));
//            System.out.println(fibonacci2(i));
        }

    }

    private static int fibonacci1(int num) {
        if (num <= 0) return 0;
        if (num == 1) return 1;
        return fibonacci1(num - 1) + fibonacci1(num - 2);
    }


    /**
     * 优化一下实现，将每次计算过的结果进行保存，不需要每次都进行计算
     */
    private static int fibonacci2(int num) {
        int [] result = {0,1};
        if (num <=1){
            return result[num];
        }

        int indexOne = 0;
        int indexTwo = 1;

        int N = 0;
        for (int i = 2; i <= num; i++) {
            N = indexOne + indexTwo;
            indexOne = indexTwo;
            indexTwo = N;
        }

        return N;
    }



}
