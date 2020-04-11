### 寻找二维数组中的数字

```java
/**
 * 1  2   4   6
 * 2  4   9  12
 * 4  7  10  13
 * 6  8  11  15
 * 求数字7是否在二维数组中
 */
```

给定如上数组，每一行数字从左往右递增，每一列从上往下递增，求某个数字是否在数组中

#### 思路







#### 代码实现

```java
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
```