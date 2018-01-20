package com.company;

public class Node {

    // Properties

    String character = null;
    Node next = null;
    Node previous = null;

    // Constructor

    public Node(String s) {
        this.character = s;
    }

    // Methods

    public void printNode() {
        System.out.println("Node had value: " + character);
    }

    // Helpers

    private boolean hasNext() {
        return next != null;
    }
}
