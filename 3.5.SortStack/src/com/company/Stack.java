package com.company;

import java.util.EmptyStackException;

public class Stack {

    // MARK: Properties

    int count;
    int treshold;
    Node topNode;
    Stack previousStack;

    // MARK: Constructor

    public Stack(int treshold) {
        this.count = 0;
        this.treshold = treshold;
    }

    // MARK: Properties

    // Convenience method to push values
    public void push(int value) {
        Node newNode = new Node(value);
        push(newNode);
    }

    public void push(Node n){

        if (!isFull()) {
            addNodeToCurrentStack(n);
        } else {
            System.out.println("ERROR WAS FULL");
            System.exit(9);
        }
    }

    public int peek() {
        if (topNode == null) {
            System.out.println("PEEK: Stack has no topnode to peek");
        } else {
            System.out.println("PEEK: " + topNode.getData());
        }
        return topNode.getData();
    }

    public int pop() {
        if (topNode == null) {
            System.out.println("ERROR: topNode null - not poppable");
            throw new EmptyStackException();
        }

        Node nodeToReturn = topNode;
        topNode = topNode.previousNode;
        count--;
        System.out.println("popped:" + nodeToReturn.getData());

        return nodeToReturn.getData();
    }

    public Stack reversed() {
        // return the reversed stack of this one... so 1,2,3 should return 3,2,1.
        Stack reversedStack = new Stack(10);
        while (hasValues()){
            reversedStack.push(new Node(pop()));
        }

        System.out.println("reversedStack ended up:" );
        reversedStack.printStack();

        return reversedStack;
    }

    // MARK: Helpers

    public void printStack() {

        if (isLoop()) {
            System.out.println("printStack error: Stack was loop");
        }

        if (isEmpty()) {
            System.out.println("printStack error: stack was empty");
            return;
        }

        Node node = topNode;

        while (node.hasPrevious()) {
            System.out.println(" - " + node.getData());
            node = node.previousNode;
        }
        System.out.println(" - " + node.getData() + "\n");
    }

    private void addNodeToCurrentStack(Node n) {
        n.previousNode = topNode;
        topNode = n;
        count++;
    }

    public boolean isFull() {
        return (count >= treshold);
    }

    public boolean hasValues() { return (count > 0); }

    public boolean isEmpty() {
        return count == 0;
    }

    // MARK: Helpers

    private boolean isLoop() {

        if (count == 0 || topNode == null) {
            return false;
        }

        Node walker = topNode;
        Node runner = topNode.previousNode;

        while (runner != null && walker != null && walker.previousNode != null && runner.previousNode != null && walker.previousNode != walker && runner.previousNode != runner) {

            walker = walker.previousNode;
            runner = runner.previousNode.previousNode;
        }
        return false;
    }
}
