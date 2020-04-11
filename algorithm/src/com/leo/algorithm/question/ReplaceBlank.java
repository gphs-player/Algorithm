package com.leo.algorithm.question;

/**
 * 1.把空格替换成指定的内容，比如 %20
 * 2.题目变形：合并两个有序数组A1,A2（给定足够长的空间）
 */
public class ReplaceBlank {



    public static void main(String [] args){
        //前后都有空格，连续的空格
        String msg = " We are family  ! ";

        char[] chars = msg.toCharArray();
        System.out.println(chars.length);

        char[] replaceBlank = replaceBlank(chars);
        System.out.println(replaceBlank);


    }

    private static char[] replaceBlank(char[] arr){
        int blankNum = 0;
        for (char c : arr) {
            if (c == ' '){
                blankNum ++;
            }
        }

        char[] newChar = new char[arr.length + blankNum * 2];



        int originIndex = arr.length -1;
        int newIndex = newChar.length - 1;
        //新字符串的长度
        System.out.println(newChar.length);


        for (; originIndex >= 0  ; originIndex--) {
            if (arr[originIndex] != ' '){
                newChar[newIndex] =arr[originIndex];
                newIndex--;
            }else {
                newChar[newIndex--] ='0';
                newChar[newIndex--] ='2';
                newChar[newIndex--] ='%';
            }
        }
        return newChar;

    }
}
