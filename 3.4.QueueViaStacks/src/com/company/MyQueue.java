package com.company;

public class MyQueue {

    // MARK: Properties

    private Stack pushStack;
    private Stack popStack;

    // MARK: Constructor

    public MyQueue() {
        pushStack = new Stack(10);
        popStack = new Stack(10);
    }

    // MARK: Public methods

    public void push(int value) {
        // Convert back to pushStack if necessary, and push
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            pushStack.push(value);
        } else if (popStack.isEmpty() && pushStack.hasValues()) {
            pushStack.push(value);
        } else if (pushStack.isEmpty() && popStack.hasValues()) {
            pushStack = popStack.reversed();
            pushStack.push(value);
        } else {
            System.out.println("Should not make it this far");
            System.exit(9);
        }
    }

    public int pop(){
        // make a popstack by reversing the pushstach, or if it already exists, keep on poppin'
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            System.out.println("Nothing to pop");
            return -1;
        } else if (popStack.isEmpty() && pushStack.hasValues()) {
            // make a popstack and pop off the top
            popStack = pushStack.reversed();
            return popStack.pop();
        }

        // pushStack.isEmpty() && popStack.hasValues()
        return popStack.pop();
    }

    public void printStacks() {
        System.out.println("pushStack: ");
        pushStack.printStack();
        System.out.println("popStack: ");
        popStack.printStack();
    }

    public void printQueue() {
        // The popstack is the representation of the queue
        // so convert to popstack if necessary, and then print it


        if (popStack.isEmpty() && pushStack.isEmpty()) {
            System.out.println("queue is empyu");
        } else if (popStack.isEmpty() && pushStack.hasValues()) {
            popStack = pushStack.reversed();
            popStack.printStack();
        } else if (pushStack.isEmpty() && popStack.hasValues()) {
            popStack.printStack();
        } else {
            System.out.println("Should not make it this far");
            System.exit(9);
        }


    }

    // MARK: Private methods

}
