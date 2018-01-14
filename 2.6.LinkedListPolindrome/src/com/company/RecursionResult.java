package com.company;

public class RecursionResult {

    boolean wasEqual = false;
    Node node = null;

    public RecursionResult(Node n, boolean p) {
        this.node = n;
        this.wasEqual = p;
    }

    public RecursionResult() { }
}
