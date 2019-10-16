## 快速排序

​	主要思想是分治法，在每轮循环中挑选一个基准元素，让其他比它大的元素移动到数列的一边，小的元素移动到另一边，从而把数列拆分成两个部分。

####  *时间复杂度*

​	平均 O(logn),最坏O(n²)

#### *分治法*

​	分而治之的思想，把一个大问题分解为若干个相同的小问题。

#### *基准元素*

​	最简单的方式是挑选第一个元素，但是极端情况（完全逆序的）下第一个元素并不合适，所以可以随机挑选一个元素，比如`（0+arr.length）/2`

### 双边排序

思路：选定基准元素，并设置两个指针`left`和`right`，指向最左和最右两个元素并进行第一次循环：

​	从right指针开始，让指针指向的元素和pivot基准元素比较，如果大于基准元素，则让指针向左移动一位；如果小于基准元素，切换到left指针，如果left指针指向的元素小于等于基准元素，指针右移一位，如果大于基准元素，left指针停止移动。然后交换左右指针的值。

```java
private static void quickSortDouble(int[] arr, int startIndex, int endIndex) {
    //递归条件结束，startIndex大于等于endIndex
    if (startIndex >= endIndex) {
        return;
    }
    int pivotIndex = partitionDouble(arr, startIndex, endIndex);
    quickSortDouble(arr, startIndex, pivotIndex - 1);
    quickSortDouble(arr, pivotIndex + 1, endIndex);
}
private static int partitionDouble(int[] arr, int startIndex, int endIndex) {

    int pivot = arr[startIndex];
    int left = startIndex;
    int right = endIndex;
    while (left != right) {
        //控制right指针比较并左移
        while (left < right && arr[right] > pivot) {
            right--;
        }
        while (left < right && arr[left] <= pivot) {
            left++;
        }
        if (left < right) {
            int p = arr[left];
            arr[left] = arr[right];
            arr[right] = p;
        }
    }
    //pivot和指针重合点交换
    arr[startIndex] = arr[left];
    arr[left] = pivot;
    System.out.println(left);
    return left;
}
```

### 单边排序

思路：选定基准元素，并且设置一个mark指针指向数组的起始位置，这个mark指针代表的是小于基准元素的区域边界，接下来从基准元素的下一个元素开始遍历，如果遍历到的元素大于基准元素，就继续往后遍历，如果小于基准元素，则要：

​	把mark指针右移一位，因为小于pivot的元素多了一个，然后让最新遍历到的元素和mark指针的元素互相交换，因为最新的元素属于最小pivot的区域。

```java
private static void quickSortSingle(int arr[], int startIndex, int endIndex) {
    if (startIndex >= endIndex) {
        return;
    }
    int pivotIndex = partitionSingle(arr, startIndex, endIndex);
    quickSortSingle(arr, startIndex, pivotIndex - 1);
    quickSortSingle(arr, pivotIndex + 1, endIndex);
}
private static int partitionSingle(int[] arr, int startIndex, int endIndex) {
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
    //每轮循环结束后，交换mark位置元素和pivot的基准值
    arr[startIndex] = arr[mark];
    arr[mark] = pivot;
    return mark;
}
```

### 非递归实现

思路：递归原本也就是方法栈的调用，每一次循环让栈顶元素出栈，通过分治法按照基准元素的位置分为两个部分，左右两个部分再入栈。等栈空的时候，循环就结束了。

```java
private static void quickSortStack(int arr[], int startIndex, int endIndex) {
    Stack<Map<String, Integer>> quickSortStack = new Stack<>();
    Map<String, Integer> rootParam = new HashMap<>();
    rootParam.put("startIndex", startIndex);
    rootParam.put("endIndex", endIndex);
    quickSortStack.push(rootParam);
    while (!quickSortStack.isEmpty()) {
        Map<String, Integer> param = quickSortStack.pop();
		    //单边排序的分治策略
        int piviot = partitionSingle(arr, param.get("startIndex"), param.get("endIndex"));
        if (param.get("startIndex") < piviot - 1) {
            Map<String, Integer> leftParam = new HashMap<>();
            leftParam.put("startIndex",param.get("startIndex"));
            leftParam.put("endIndex",piviot - 1);
            quickSortStack.push(leftParam);
        }
        if (piviot + 1 < param.get("endIndex")){
            Map<String, Integer> rightParam = new HashMap<>();
            rightParam.put("startIndex",piviot + 1);
            rightParam.put("endIndex",param.get("endIndex"));
            quickSortStack.push(rightParam);
        }
    }
}
```