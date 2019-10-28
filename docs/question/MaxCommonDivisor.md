## 求两个数的最大公约数

```java
/**
 * 暴力破解
 * 从最小数的一半开始，尝试能否找到同时被两个数字整除的公约数
 * 效率很差
 * 10000和10001，要循环4999次
 */
private static int getCommon1(int a, int b) {

    int big = a > b ? a : b;
    int small = a > b ? b : a;

    if (big % small == 0) {
        return small;
    }
    //从最小数字的一半开始，
    for (int i = small / 2; i > 1; i--) {
        if (small % i == 0 && big % i == 0) {
            return i;
        }
    }
    return 1;
}

/**
 * 辗转相除法
 * 两个正整数a b （a > b）
 * 最大公约数就是a除以b的余数c和b之间的最大公约数
 * 10和25：25除以10商2余5 ，最大公约数就是10和5之间的最大公约数
 * 当两个整数较大的时候，取模运算性能差
 */
private static int getCommon2(int a, int b) {
    int big = a > b ? a : b;
    int small = a > b ? b : a;
    if (big % small == 0) {
        return small;
    }
    return getCommon2(big % small, small);
}


/**
 * 更相减损术
 * 两个正整数a > b
 * 最大公约数等于a-b的差值c和较小数b的最大公约数
 * 依靠两数求差值方式递归，当两数相差悬殊大的时候，运算次数就会很多。
 */
private static int getCommon3(int a, int b) {
    int big = a > b ? a : b;
    int small = a > b ? b : a;
    if (big % small == 0) {
        return small;
    }
    return getCommon3(big - small, small);
}

/**
 * 更相减损和辗转相除结合
 * <p>
 * 假设方法名为gcf
 * <p>
 * 1.当a和b都是偶数的时候，gcf(a,b) = 2 * gcf (a/2,b/2) = 2 * gcf(a>>1,b>>1)
 * 2.当a为偶数，b为奇数，gcf(a,b) = gcf(a>>1,b)
 * 3.当a为奇数，b为偶数，gcf(a,b) = gcf(a,b>>1)
 * 4.当a,b都是奇数的时候，运用更相减损，gcf(a,b) = gcf(b,a-b),此时：a-b肯定是偶数。然后继续唯一运算
 */
private static int getCommonFinal(int a, int b) {
    if (a == b) return a;
    //两者都是偶数
    if ((a & 1) == 0 && (b & 1) == 0) {
        return getCommonFinal(a >> 1, b >> 1) << 1;
    } else if ((a & 1) == 0 && (b & 1) != 0) {//a是偶数,b是奇数
        return getCommonFinal(a >> 1, b);
    } else if ((a & 1) != 0 && (b & 1) == 0) {//a是奇数,b是偶数
        return getCommonFinal(a, b>>1);
    } else {//两者都是奇数
        int big = a >b ? a : b;
        int small = a<b ? a : b;
        return getCommonFinal(big - small, small);
    }
}
```