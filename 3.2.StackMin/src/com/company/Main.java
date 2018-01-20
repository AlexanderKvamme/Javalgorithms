package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(10);
        stack.push(8);
        stack.push(20);
        stack.push(6);
        stack.push(30);
        stack.push(4);
        stack.push(40);
        stack.push(2);
        stack.push(50);
        stack.push(1);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        stack.push(100);

        System.out.println("\nCount: " + stack.count);

        while (!stack.isEmpty()) {
            stack.pop();
        }

        System.out.println("DONE");
    }
}
