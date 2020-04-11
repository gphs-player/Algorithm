### 旋转数组求最小值



#### 思路

选定两个指针指向数组的首位和末位,如下图P1和P2P
分别和数组中间的值做比较，中间的值是5
如果中间值大于首位，说明中间值处于第一部分递增数组，否则属于第二部分递增数组
然后将首位和末位的索引更改，缩小范围重复上述步骤，比如5大于首位的3，那么就将P1移至5的索引处。

<img src="../../pics/rotate_arr.png" width=300 align=left>



#### 代码

```java
public static void main(String[] args) {
    //相对有序的数组
    int [] arr = {3,4,5,1,2};
    System.out.println(min(arr,arr.length));
}

private static int min(int[] arr, int length) {
    if (arr == null || arr.length == 0) throw new IllegalStateException("Invalid args !!!");
    int start = 0;
    int end = length - 1;
    int mid = start;//如果旋转数组已经是有序的，那么第一个值就应该是返回值，所以先把mid指向start
 
    while (arr[start] > arr[end]) {
        if (end - start == 1) {
            mid = end;
            break;
        }
        mid = (start + end)/2;

        if (arr[mid] > arr[start]){
            start = mid;
        }else if (arr[mid] <= arr[end]){
            end = mid;
        }
    }

    return arr[mid];
}
```