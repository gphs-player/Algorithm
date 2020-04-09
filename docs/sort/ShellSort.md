### 希尔排序

目前看不懂什么意思。😅

```java
public static <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] list) {
    int j;
    for (int gap = list.length / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < list.length; i++) {
            AnyType tmp = list[i];
            for (j = i; j >= gap && tmp.compareTo(list[j - gap]) < 0; j -= gap) {
                list[j] = list[j-gap];
            }
            list[j] = tmp;
        }
    }
}
```