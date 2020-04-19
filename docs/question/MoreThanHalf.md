### 出现次数超过数组长度一半的数字

#### 思路

出现次数超过一半，那么肯定是处于数组中间位置的

#### 基于分治法的快速排序

快排会找一个随机数值MASK，将数组中小于这个值的元素排在左边，大于它的排在右边，如果排序之后MASK正好处于数组中间的位置，那么它就是要找的数字。

```java
public class MoreThanHalf {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 2, 5, 2, 2};
        moreThanHalfNum(arr);
    }

    private static void moreThanHalfNum(int[] arr) {
        if (arr == null || arr.length <= 0) {
            System.out.println("Illegal params !!!");
            return;
        }

        int middle = arr.length >> 1;
        int start = 0;
        int end = arr.length - 1;

        int index = partition(arr, 0, arr.length - 1);

        while (index != middle) {
            if (index > middle) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(arr, start, end);

        }

        int result = arr[middle];
        boolean moreThanHalf = checkMoreThanHalf(arr, result);
        if (moreThanHalf) {
            System.out.println(result);
        } else {
            System.out.println("没有满足条件的数值");
        }
    }

    private static boolean checkMoreThanHalf(int[] arr, int result) {
        int times = 0;
        for (int indexValue : arr) {
            if (indexValue == result) {
                times++;
            }
        }
        if (times * 2 >= arr.length) {
            return true;
        }
        return false;
    }

    /**
     * 基于分治法找出中位数
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }
}
```



#### 基于计数的思路

数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现次数的和还要多。因此我们可以考虑在遍历数组的时候保存两个值：一个是数组中的一个数字，一个是次数。当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加1；如果下一个数字和我们之前保存的数字不同，则次数减1。如果次数为零，我们需要保存下一个数字，并把次数设为1。由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，那么要找的数字肯定是最后一次把次数设为1时对应的数字。



```java
private static void moreThanHalfNumCount(int[] arr) {
    int result = arr[0];
    int times = 1;

    for (int i = 1; i < arr.length; i++) {
        int item = arr[i];
        if (times == 0) {
            result = item;
            times = 1;
        } else if (item == result) {
            times++;
        } else {
            times--;
        }
    }
    System.out.println(result);
}
```

也要注意次数和参数校验