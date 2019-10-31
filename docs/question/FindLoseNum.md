## 寻找缺失的一个数

在一个无序数组里，有99个不重复的正整数，范围是1-100，唯独缺少一个1-100中的整数，找到这个数。

### 哈希表实现

创建一个哈希表，1-100这100个整数为KEY，遍历整个数组，读到一个整数，就定位到哈希表中对应的KEY，删除这个KEY，最终只剩下一个KEY。假设数组长度是n,时间复杂度和空间复杂度都是O(n)。

### 排序

​	对数组排序，然后遍历数组，发现相邻的元素不连续，缺少的就是这个数。时间复杂度上升O(nlogn),空间复杂度O(1)

### 优化

算出1-100累加和，然后减去数组所有元素，剩余的就是确实的数字。时间复杂度O(n)，空间复杂度O(1)



### 扩展

#### 第一次扩展

​	无序数组有若干个正整数，范围是1-100，其中99个整数都出现了偶数次，只有一个整数出现了奇数次，如何找到这个数。

​	利用异或运算，相同的数字异或的值是0.最后剩下的值就是结果。时间复杂度是O(n),空间复杂度O(1)

#### 第二次扩展

​	刚才的数组，有98个整数出现了偶数次，只有2个整数出现了奇数次，找到这两个数？

​	将所有数字进行异或运算，得到的结果就是两个数字的异或结果，比如运算结果是`0000 0110B`，结果中肯定会至少有一位是1，选定其中一位1，那么两个数字在这位上肯定是不等的，如例子中的倒数第二位。依次可以将数组分为两组，第一组的倒数第二位是0，第二组的倒数第二位是1。然后分别将两组进行异或运算，求出最终结果。

#### 代码

```java
private static int [] findLostNums(int [] array){
    //用于存储结果
    int result[] = new int[2];
    int xorResult = 0;
    for (int i = 0; i < array.length; i++) {
        xorResult ^= array[i];
    }
    //如果所有数字运算结果是0，说明题目不符合要求
    if (xorResult == 0){
        return null;
    }

    //确定2个整数的不同位，以此分组
    int separator =1;
    while ( 0 == (xorResult&separator)){
        separator<<=1;
    }
    for (int i = 0; i < array.length; i++) {
        //两个数被分为两个组，每个组的异或运算值的最终结果都是求的数
        if (0 == (array[i]&separator)){
            result[0]^=array[i];
        }else {
            result[1]^=array[i];
        }
    }
    return result;
}
```

​	