package com.company;

import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);

        queue.printStacks();

        queue.pop();
        queue.pop();
        queue.pop();

        queue.printStacks();
        queue.printQueue(); // Expected: 4,5

        queue.pop();
        queue.printQueue(); //  Expected: 5
    }
}
