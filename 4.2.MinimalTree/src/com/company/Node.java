package com.company;


import java.lang.reflect.Array;
import java.util.Arrays;

/// This node is a good old fashioned tree node
public class Node {

    // MARK: Properties

    public int value;
    private int leftChildren;
    private int rightChildren;
    public int leftHeight;
    public int rightHeight;
    public Node leftChild = null;
    public Node rightChild = null;
    public Node parent = null;

    // MARK: Constructors

    public Node(int value) {
        this.value = value;
    }

    // MARK: Methods

    private void separateArrayAroundNode(int[] array, Node node) {
        // get center




        // append left part of array to left
        // append right side of array to right
    }

    // instance method on node, takes an array and sets the nodes value from the array's center value,
    // and sends left side to its left child, and the right side to the right child


    // Helpers

    public void addLeftChild(int value) {
        Node newNode = new Node(value);
        leftChild = newNode;
        leftChild.parent = this;
        leftChildren++;
    }

    public void addRightChild(int value) {
        Node newNode = new Node(value);
        rightChild = newNode;
        rightChild.parent = this;
        rightChildren++;
    }





}
