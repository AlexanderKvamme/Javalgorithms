package com.company;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackOfStacks {

    // MARK: Properties

    int treshhold;
    Stack topStack;
    ArrayList<Stack> stackList = new ArrayList<>();

    // MARK: Constructor

    public StackOfStacks(int treshhold) {
        this.treshhold = treshhold;
        this.stackList.add(new Stack(treshhold));
    }

    // MARK: Methods

    public int popAt(int i) {
        System.out.println("popping stack: " + i);
        stackList.get(i).printStack();
        return stackList.get(i).pop();
    }

    public void printStacks() {

        int i = 0;
        for(Stack stack : stackList) {
            System.out.println("\nPrinting stack " + i);
            stack.printStack();
            i++;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);

        if (topStack == null || topStack.isFull()) {
            // Make new stack for the new node
            makeNewStackWithNode(newNode);
        } else {
            topStack.push(newNode);
        }
    }

    public int pop() {
        if (topStack == null) {
            System.out.println("topStack null: not poppable");
            throw new EmptyStackException(); }

        if (topStack.isEmpty()) {
            stackList.remove(topStack);
            topStack = topStack.previousStack;
        }

        return topStack.pop();
    }

    // MARK: Helpers

    private void makeNewStackWithNode(Node n) {

        if (topStack == null) {
            System.out.println("stack was null - making new");
        } else if (topStack.isFull()) {
            System.out.println("Stack was full - making new");
        }
        Stack newStack = new Stack(treshhold);
        newStack.previousStack = topStack;
        topStack = newStack;
        newStack.push(n);
        stackList.add(newStack);
    }
}
