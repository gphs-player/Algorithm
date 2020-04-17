### 顺时针打印矩阵

给定如下矩阵，打印顺序为 1-2-3-4-8-12-16-15-14-13-9-5-6-7-11-10

```
1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16
```

#### 分析

接下来分析循环结束的条件。假设这个矩阵的行数是rows，列数是columns。打印第一圈的左上角的坐标是（1,1），第二圈的左上角的坐标是（2,2），依此类推。我们注意到，左上角的坐标中行标和列标总是相同的，于是可以在矩阵中选取左上角为（start, start）的一圈作为我们分析的目标。

对一个5×5的矩阵而言，最后一圈只有一个数字，对应的坐标为（2,2）。我们发现5>2×2。对一个6×6的矩阵而言，最后一圈有4个数字，其左上角的坐标仍然为（2,2）。我们发现6>2×2依然成立。于是我们可以得出，让循环继续的条件是columns>startX×2并且rows>startY×2。

在打印的时候需要注意的是边界值。

#### 代码

```java
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
```