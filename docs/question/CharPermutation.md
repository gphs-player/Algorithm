### 字符全排列

#### 思路

首先求所有可能出现在第一个位置的字符，即把第一个字符和后面所有的字符交换。就是分别把第一个字符a和后面的b、c等字符交换的情形。首先固定第一个字符，求后面所有字符的排列。这个时候我们仍把后面的所有字符分成两部分：后面字符的第一个字符，以及这个字符之后的所有字符。然后把第一个字符逐一和它后面的字符交换……

#### 代码

```java
public class CharPermutation {

    public static void main(String[] args) {
        char[] ch = {'a', 'b', 'c', 'd'};
        permutation(ch, 0);
    }
    private static void permutation(char[] ch, int index) {
        if (index == ch.length - 1) {
            System.out.println(Arrays.toString(ch));
        }
        //将第一个字符依次和其余字符替换，得到所有字符出现在首位的全排列
        for (int i = index; i < ch.length; i++) {
            char tmp = ch[index];
            ch[index] = ch[i];
            ch[i] = tmp;

            permutation(ch, index + 1);
            tmp = ch[index];
            ch[index] = ch[i];
            ch[i] = tmp;

        }
    }
}
```

