### 交换奇偶数

给定一个数组，使得数组中奇数位于偶数之前。

#### 思路

遍历数组，遇到一个偶数，就将其拿出暂存，然后前移剩下的所有数字，最后末位有空位置，将偶数放在空位。这样的一个思路是基本的，时间复杂度为O(n²)。

更好一点的想法？

使用两个指针，第一个指针初始化时指向数组的第一个数字，它只向后移动；第二个指针初始化时指向数组的最后一个数字，它只向前移动。在两个指针相遇之前，第一个指针总是位于第二个指针的前面。如果第一个指针指向的数字是偶数，并且第二个指针指向的数字是奇数，我们就交换这两个数字

```java
private static void changeOddEven(int[] arr) {
    if (arr == null || arr.length == 0) return;
    int startIndex = 0;
    int endIndex = arr.length - 1;
    while (startIndex < endIndex) {
        //指向第一个偶数
        while (startIndex < endIndex && (arr[startIndex] & 0x1) != 0) {
            startIndex++;
        }
        //指向最后的奇数
        while (startIndex < endIndex && (arr[endIndex] & 0x1) == 0) {
            endIndex--;
        }

        if (startIndex < endIndex) {
            int tmp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = tmp;
        }
    }
}
```



#### 扩展

如果想要按照大小排列，负数位于正数之前？

能被3整除的在前，不能被3整除的在后？

可以接收一个函数，判断的逻辑放在函数中。之前的方法只负责交换

```java
public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	  //int[] arr = {1, -1, 2, 3, 4, -6, -8, -2, 5, 6, 7, 8, 9, 10,- 3};
    changeOddEven(arr, new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            return (integer & 0x1) == 0;
            //return integer > 0;
        }
    });
    System.out.println(Arrays.toString(arr));
}

private static void changeOddEven(int[] arr, Predicate<Integer> isEven) {
    if (arr == null || arr.length == 0) return;
    int startIndex = 0;
    int endIndex = arr.length - 1;
    while (startIndex < endIndex) {
        //指向第一个偶数
        while (startIndex < endIndex && !isEven.test(arr[startIndex])) {
            startIndex++;
        }
        //指向最后的奇数
        while (startIndex < endIndex && isEven.test(arr[endIndex])) {
            endIndex--;
        }
        if (startIndex < endIndex) {
            int tmp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = tmp;
        }
    }
}
```