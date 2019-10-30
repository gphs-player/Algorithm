package com.leo.algorithm.question;

/**
 * 删除K个数字之后，留下的数字尽可能小
 * 时间复杂度和空间复杂度都是O(n)
 */
public class RemoveKDigits {

    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212",3));
        System.out.println(removeKDigits("30200",1));
        System.out.println(removeKDigits("10",2));
    }

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
}
