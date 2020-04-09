### 插入排序

>  时间复杂度：O(n²)

* 由N-1趟排序组成

* 对于第p趟排序（p=1到N-1），保证0到p之间的元素已经是排序状态

具体算法如下：

```java
public static <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] list) {
    int j;
    for (int p = 1; p < list.length; p++) {
        AnyType tmp = list[p];
        for (j = p; j > 0 && tmp.compareTo(list[j - 1]) > 0; j--) {
            list[j] = list[j - 1];
        }
        list[j] = tmp;
        System.err.println(Arrays.toString(list) +"\n");
    }
}
```



每次排序结果输出

```
[8, 5, 1, 4, 9, 3, 2, 7, 6]

[8, 5, 1, 4, 9, 3, 2, 7, 6]

[8, 5, 4, 1, 9, 3, 2, 7, 6]

[9, 8, 5, 4, 1, 3, 2, 7, 6]

[9, 8, 5, 4, 3, 1, 2, 7, 6]

[9, 8, 5, 4, 3, 2, 1, 7, 6]

[9, 8, 7, 5, 4, 3, 2, 1, 6]

[9, 8, 7, 6, 5, 4, 3, 2, 1]
```

