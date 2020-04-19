### 最小的K个数字


#### 基于快速排序的O(n)

会修改原有数据

```java
public static void main(String[] args) {
    int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    leastK(arr, 4);
}

private static void leastK(int[] arr, int k) {
    int start = 0;
    int end = arr.length - 1;
    int index = partition(arr, start, end);

    while (index != k - 1) {
        if (index > k - 1) {
            end = index - 1;
        } else {
            start = index + 1;
        }
        index = partition(arr, start, end);
    }
    for (int i = 0; i < k; i++) {
        System.out.println(arr[i]);
    }
}

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
```



#### 基于计数的O(n*log k)

借助辅助空间，特别适合处理海量数据。不影响原有数据。

我们可以先创建一个大小为k的数据容器来存储最小的k个数字，接下来我们每次从输入的n个整数中读入一个数。如果容器中已有的数字少于k个，则直接把这次读入的整数放入容器之中；如果容器中已有k个数字了，也就是容器已满，此时我们不能再插入新的数字而只能替换已有的数字。找出这已有的k个数中的最大值，然后拿这次待插入的整数和最大值进行比较。如果待插入的值比当前已有的最大值小，则用这个数替换当前已有的最大值；如果待插入的值比当前已有的最大值还要大，那么这个数不可能是最小的k个整数之一，于是我们可以抛弃这个整数。

因此当容器满了之后，我们要做3件事情：一是在k个整数中找到最大数；二是有可能在这个容器中删除最大数；三是有可能要插入一个新的数字。如果用一个二叉树来实现这个数据容器，那么我们能在O（logk）时间内实现这三步操作。因此对于n个输入数字而言，总的时间效率就是O（nlogk）。

我们可以选择用不同的二叉树来实现这个数据容器。由于每次都需要找到k个整数中的最大数字，我们很容易想到用最大堆。
