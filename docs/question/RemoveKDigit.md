## 删除k个数字后的最小值

举例：给出一个整数541270936，删除一个数字后，让剩下的数字尽可能小，无论删除哪个数字，都是从9位数变成8位数。

### 思路

数字的大小很重要，但是数字的位置也很重要，应该优先把高位的数字降低，这样对新整数的影响最大。

具体做法是：原数字从左往右进行比较，如果发现某一个数字大于它右边的数字，那么在删除该数字后，得到的结果就是最优的。

```
541270936 - 41270936

41270936 - 1270936

1270936 - 120936
```

#### 贪心算法

依次求得局部最优解，最终得到全局最优解，这种思想就是贪心算法。

### 代码

```java
private static String removeKDigits(String num, int k) {
    int newLength = num.length() - k;

    char[] stack = new char[num.length()];

    int top = 0;
    for (int i = 0; i < num.length(); ++i) {
        char c = num.charAt(i);
        //当栈顶数字大于遍历到的当前数字时，栈顶数字出栈
        while (top > 0 && stack[top - 1] > c && k > 0) {
            top -= 1;
            k -= 1;
        }
        stack[top++] = c;
    }
    int offset = 0;
    while (offset < newLength && stack[offset] == '0') {
        offset++;
    }
    return offset == newLength ? "0" : new String(stack, offset, newLength - offset);
}
```