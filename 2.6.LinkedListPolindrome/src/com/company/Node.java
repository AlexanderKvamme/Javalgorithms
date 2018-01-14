package com.company;

public class Node {

    // Properties

    Character character = null;
    Node next = null;
    Node previous = null;

    // Constructor

    public Node(Character i) {
        this.character = i;
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
