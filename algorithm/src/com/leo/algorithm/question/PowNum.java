package com.leo.algorithm.question;

/**
 * 求数值的整数次方
 */
public class PowNum {

    public static void main(String[] args) {
        System.out.println(pow(2,-1));
    }

    private static double pow(double base, int exponent) {
        if (isEqual(base, 0) && exponent < 0) {
            return 0;
        }

        int absExponent = exponent;

        if (exponent < 0) {
            absExponent = -exponent;
        }

        double result = powNum(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }

        return result;
    }

    private static double powNum(double base, int absExponent) {
        double result = 1.0;
        for (int i = 0; i < absExponent; i++) {
            result *= base;
        }
        return result;
    }

    /**
     * 一个数的32次方等于两次16次方相乘，16次方等于两次8次方
     * a的n次方等于
     * 偶数     a的（n/2）次方 * a的（n/2）次方
     * 奇数     a的（(n-1)/2）次方 * a的（(n-1)/2）次方 * a
     */
    private static double powNumEffect(double base, int absExponent) {
        if (absExponent == 0)return 1;
        if (absExponent == 1)return base;
        double result = powNumEffect(base,absExponent >> 1);
        result *= result;

        if ((absExponent & 0x1) == 1){//如果是奇数还要再乘一次base
            result *= base;
        }
        return result;
    }


    private static boolean isEqual(double num1, double num2) {
        //在某一精度上取近似等于
        if (num1 - num2 > -0.0000001 && num1 - num2 < 0.0000001) {
            return true;
        }
        return false;
    }

}
