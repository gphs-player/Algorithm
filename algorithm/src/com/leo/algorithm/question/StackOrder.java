package com.leo.algorithm.question;

import java.util.Stack;

public class StackOrder {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int order1[] = {4, 5, 3, 2, 1};
        int order2[] = {4, 2, 5, 1, 3};
        int order3[] = {3, 5, 4, 2, 1};


        boolean isCorrectOrder = check(arr, order3);
        System.out.println(isCorrectOrder);
    }

    private static boolean check(int[] arr, int[] order1) {

        Stack<Integer> stack = new Stack<>();

        int indexPush = 0;
        int indexPop = 0;
        while (indexPop < order1.length) {
            while (stack.isEmpty() || stack.peek() != order1[indexPop]){
                if (indexPush >= order1.length ) {
                    break;
                }
                stack.push(arr[indexPush]);
                indexPush++;
            }
            if (stack.peek() != order1[indexPop]) {
                break;
            }
            stack.pop();
            indexPop++;
        }
        if (stack.isEmpty() && indexPop == order1.length) {
            return true;
        }
        return false;
    }
}
