## 堆排序



### 回顾二叉堆

最大堆的堆顶是整个堆中的最大元素

最小堆的堆顶是整个堆中的最小元素

如果一次取出堆中的堆顶，是不是就按照最大最小顺序进行了排序？



### 思路

将无序数组构建成二叉堆（根据需求决定是最大堆还是最小堆）；

循环删除堆顶的元素，并将元素放置堆的末位；

调整二叉堆（已经删除的元素不在调整之内），产生新的二叉堆。



### 代码

```java
//下沉操作
private static void downAdjust(int[] arr, int parentIndex, int length) {
    int temp = arr[parentIndex];
    //左孩子
    int childIndex = 2 * parentIndex + 1;
    while (childIndex < length) {
        //如果有右孩子,并且大于左孩子，定位到右孩子
        if (childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex]) {
            childIndex++;
        }
        //如果父节点大于任何一个孩子，则直接跳出
        if (temp > arr[childIndex]) {
            break;
        }
        arr[parentIndex] = arr[childIndex];
        parentIndex = childIndex;
        childIndex = 2 * childIndex + 1;
    }
    arr[parentIndex] = temp;
}

/**
 * 堆排序  升序
 */
private static void headSort(int arr[]) {
    //从最后一个结点开始，构建最大堆 O(n)
    for (int i = (arr.length - 2) / 2; i >= 0; i--) {
        downAdjust(arr, i, arr.length);
    }
    System.out.println(Arrays.toString(arr));

    //循环删除堆顶元素，移动到集合尾部，再调整堆顺序 O(nlogn)
    for (int i = arr.length - 1; i >0 ; i--) {
        int temp = arr[i];
        arr[i] = arr[0];
        arr[0] = temp;
        downAdjust(arr,0,i);
    }
}
```



### 复杂度分析

“下沉”操作是算法的基础，时间复杂度为O(logn)

构建二叉堆的时间复杂度，O(n)

循环删除并下沉调整堆顶，O(nlogn)

所以整体的时间复杂度是O(nlogn)

空间复杂度O(1)

### 最坏情况

O(nlogn)