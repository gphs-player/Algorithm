package com.leo.algorithm.question;

import java.util.Stack;

/**
 * 最小栈，实现push、top、getMin方法为 常数时间复杂度
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);

        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }


    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    private void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    private void pop() {
        mainStack.pop();
        minStack.pop();
    }


    public Integer getMin() {
        assert (minStack.size() > 0 && mainStack.size() > 0);
        return minStack.peek();
    }

}
