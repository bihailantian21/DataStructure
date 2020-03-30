package com.zcr.test;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> help = new Stack<>();

    public void push(int value) {
        stack.push(value);
        if (help.isEmpty()) {
            help.push(value);
        }
        if (value < help.peek()) {
            help.push(value);
        } else {
            help.push(help.peek());
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is Empty");
        }
        help.pop();
        return stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is Empty");
        }
        return stack.peek();
    }

    public int getMin() {
        return help.pop();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> 返回 -3
        minStack.pop();
        System.out.println(minStack.top());      //--> 返回 0
        System.out.println(minStack.getMin());   //--> 返回 -2
    }


}
