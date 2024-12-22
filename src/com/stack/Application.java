package com.stack;

public class Application {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.insert(10);
        stack.insert(154);
        stack.insert(160);

        stack.peek();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
