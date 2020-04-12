package com.leo.algorithm.question;

/**
 * 计算二进制中的1
 */
public class CountOneInBinary {

    public static void main(String[] args) {
        for (int i = -10; i <= -1; i++) {

//            System.out.println(countWithFlag(i));
            System.out.println(countWithSelf(i));
        }
    }
//    0000 0001
//    0000 0010
//    0000 0011
//    0000 0100
//    0000 0101
//    0000 0110
//    0000 0111
//    0000 1000
//    0000 1001
//    0000 1010

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



    private static int countWithSelf(int n){
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count += 1;
        }
        return count;
    }


}
