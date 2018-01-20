package com.company;

public class Node {

    // MARK: Properties

    private int data;
    public Node previousNode;

    // MARK: Constructor

    public Node(int data) {
        this.data = data;
    }

    // MARK: Methods

    public int getData() {
        return this.data;
    }
    public boolean hasPrevious() {
        return previousNode != null;
    }
}
