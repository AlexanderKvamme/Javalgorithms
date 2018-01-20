package com.company;

import java.util.EmptyStackException;
import java.util.MissingResourceException;

// Gonna make this generic

public class MyStack<T extends Integer>{

    // MARK: Properties

    int count = 0;
    Node<T> top;
    Node<T> min;

    // MARK: Classes

    private class Node<T extends Integer> {

        // Properties

        private T data;
        private Node<T> next;
        private Node<T> previousMin;

        // Constructor

        public Node(T item) {
            this.data = item;
        }
    }

    // Methods

    public void push(T item) {
        System.out.println("pushing " + item);

        Node newNode = new Node(item);

        // Update min node
        if (min == null) {
            min = newNode;
        } else {
            setNewMinNode(newNode);
        }

        // Update general
        newNode.next = top;
        top = newNode;
        count++;
    }

    public T pop() {

        if (top == null) {
            throw new EmptyStackException();
        }

        // Update min node
        if (top == min) {
            min = top.previousMin;
        }

        System.out.println("\n----Pop(" + top.data.intValue()+ ")---");
        //System.out.println("top next was: " + top.next.data);
        System.out.println("COUNT--");
        count--;
        System.out.println("count now: " + count);
        System.out.println("-------\n");

        // Update general
        T valueToReturn = top.data;
        top = top.next;
        return valueToReturn;
    }

    public T peek() {
        if (top == null) { throw new EmptyStackException(); }
        return top.data;
    }

    public T min() {
        return min.data;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private void setNewMinNode(Node newMin) {
        if (newMin.data.intValue()  < min.data.intValue()) {
            newMin.previousMin = min;
            min = newMin;
        }
    }
}
