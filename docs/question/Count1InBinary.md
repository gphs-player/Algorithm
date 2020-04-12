### 计算二进制中1的个数

​	把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于是把整数的二进制表示中的最右边一个1变成0。很多二进制的问题都可以用这个思路解决。

#### 第一种解法

从右往左，防止负数出现死循环

```java
private static int countWithFlag(int n) {
    int flag = 1;
    int count = 0;
    int bitNum = 32;
    while (bitNum-- > 0) {
        if ((n & flag) != 0) {
            count++;
        }
        flag = flag << 1;
    }
    return count;
}
```

#### 第二种解法

一个数n与n-1做&运算，会把最右边的1变为0 

```java
private static int countWithSelf(int n){
    int count = 0;
    while (n != 0) {
        n = n & (n - 1);
        count += 1;
    }
    return count;
}
```

#### 变形

两个数m和n的二进制数，m需要改变多少位才能变为n?

两个数做异或算法然后统计1的个数，就是需要改变的位数。