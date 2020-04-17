package com.leo.algorithm.question;

/**
 * 顺时针打印矩阵
 * <p>
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 */
public class PrintMatrix {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        printMatrix(arr, arr[0].length, arr.length);
    }

    private static void printMatrix(int[][] arr, int columns, int rows) {
        if (arr == null || columns <= 0 || rows <= 0) return;

        int start = 0;
        while (columns > start * 2 && rows > start * 2) {
            printMatrixCircle(arr, columns, rows, start);
            ++start;
        }

    }

    private static void printMatrixCircle(int[][] arr, int columns, int rows, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        //打印第一行
        for (int i = 0; i <= endX; i++) {
            int number = arr[start][i];
            printNum(number);
        }
        //从上往下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                int num = arr[i][endY];
                printNum(num);
            }
        }
        //从右往左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                int num = arr[endY][i];
                printNum(num);
            }
        }
        //从下到上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start; i--) {
                int num = arr[i][start];
                printNum(num);
            }
        }
    }

    private static void printNum(int number) {
        System.out.print(number + ":");
    }
}
