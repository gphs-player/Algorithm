package com.leo.algorithm.question;

import java.util.Stack;

/**
 * 最小栈，实现push、top、getMin方法为 常数时间复杂度
 */
public class MinStack {

    public static void main(String [] args){
        MinStack stack = new MinStack();
        stack.pushA(4);
        stack.pushA(9);
        stack.pushA(7);
        stack.pushA(3);
        stack.pushA(8);
        stack.pushA(5);

        System.out.println(stack.getMin());
        System.out.println(stack.popA());
        System.out.println(stack.popA());
        System.out.println(stack.popA());
        System.out.println(stack.getMinA());
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

    public int getMinA() {
        return minStack.peek();
    }



    public void pushA(int element){
        mainStack.push(element);
        if(minStack.isEmpty() || element <= minStack.peek()){
            minStack.push(element);
        }
    }
    public Integer popA(){
        if(mainStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        return mainStack.pop();
    }

    public Integer getMin(){
        return minStack.peek();
    }

}
