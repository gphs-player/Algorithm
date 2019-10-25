package com.leo.algorithm.question;

import java.util.Stack;

/**
 * 最小栈，实现push、top、getMin方法为 常数时间复杂度
 */
public class MinStack {

    public static void main(String [] args){
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);

        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }


    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();


    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }else{
            int tmp = stack.peek();
            stack.push(x);
            if(tmp<x){
                stack.push(tmp);
            }else{
                stack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size()-2);
    }

    public int getMin() {
        return stack.peek();
    }

}
