package com.company;

import java.util.ArrayList;
import java.util.Hashtable;

public class Node {

    // Properties

    Integer value = 0;
    Node next = null;
    Node previous = null;
    Ll owner = null;

    // Constructor

    public Node(int i) {
        this.value = i;
    }

    // Methods

    public void printNode() {
        System.out.println("Node had value: " + value);
    }

    public void delete() {

        System.out.println("Gonna delete node with value: " + value);

        if (hasNext() && hasPrevious()) { // if mid node
            previous.next = next;
            next.previous = previous;
        } else if (!hasNext() && hasPrevious()){ // if last node
            previous.next = null;
            owner.makeTail(previous);
        } else if (!hasPrevious() && hasNext()) { // if first node
            owner.makeHead(next);
            next.previous = null;
        } else {
            System.out.println("I should not be here");
        }

        owner = null;
        System.out.println("Deleted node with value: " + value);
    }

    // Helpers

    private boolean hasNext() {
        return next != null;
    }

    private boolean hasPrevious() {
        return previous != null;
    }
}
