package com.leo.algorithm.question;

import java.util.Arrays;

/**
 * 字符全排列
 */
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
