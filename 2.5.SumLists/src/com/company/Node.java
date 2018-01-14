package com.company;

public class Node {

    // Properties

    Integer value = 0;
    Node next = null;

    // Constructor

    public Node(int i) {
        this.value = i;
    }

    // Methods

    public void printNode() {
        System.out.println("Node had value: " + value);
    }

    // Helpers

    private boolean hasNext() {
        return next != null;
    }
}
