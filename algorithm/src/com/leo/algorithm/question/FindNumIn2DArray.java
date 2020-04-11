package com.leo.algorithm.question;

/**
 * 1  2   4   6
 * 2  4   9  12
 * 4  7  10  13
 * 6  8  11  15
 * <p>
 * 求数字7是否在二维数组中
 */
public class FindNumIn2DArray {

    public static void main(String[] args) {

        int[][] arrays = {
                {1, 2, 4, 6},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        System.out.println(findNum(arrays, 16));


    }


    private static boolean findNum(int[][] arr, int target) {
        boolean result = false;
        if (arr != null) {
            int rows = arr.length;//行数
            int columns = arr[0].length;//列数
            int colIndex = arr[0].length - 1;//从最后一列开始查找
            int rowIndex = 0;
            while (rowIndex < rows && colIndex >= 0) {
                if (arr[rowIndex][colIndex] == target) {
                    result = true;
                    break;
                } else if (arr[rowIndex][colIndex] > target) {
                    //该列第一个值大于目标值，前移一列
                    colIndex--;
                } else {
                    //改行都小于目标值，下移一行
                    rowIndex++;
                }
            }
            if (result) {

                System.out.println("[" + rowIndex + "," + colIndex + "]");
            } else {
                System.err.println("No match!");

            }
        }

        return result;
    }
}
