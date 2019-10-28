## 一个数是否为2的整数次幂



如果一个数是2的整数次幂，则其转化为二进制则有一下特点：

<img src="../../pics/powerof2_1.png" style="zoom:40%;"  align="left"/>

将原数减去1，再次转化为2进制

<img src="../../pics/powerof2_2.png" style="zoom:40%;"  align="left"/>

将两者进行与运算

<img src="../../pics/powerof2_3.png" style="zoom:40%;"  align="left"/>

也就是说，对于一个数n,只要计算n&(n-1)的结果是不是0即可。

```java
public boolean isPowerOf2(n){
  	return n & (n-1) == 0;
}
```

