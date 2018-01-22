package com.company;

import java.util.Arrays;

public class Main {

    // Main

    public static void main(String[] args) {

        int[] array = new int[] {2,3,4,5,6,7,8};
        int[] array2 = new int[] {2,3,4};

        Node minimalTree = makeArrayIntoMinimalBinarySearchTree(array);
    }

    // MARK: Methods

    // This function generates a tree and returns the rootnode
    // Minimal is the same as as short as possible.
    public static Node makeArrayIntoMinimalBinarySearchTree(int[] array) {
        Node rootNode = makeNodeFromArray(array);
        System.out.println(rootNode.value);
        System.out.println(rootNode.leftChild.value);
        System.out.println(rootNode.rightChild.value);
        System.out.println(rootNode.leftChild.leftChild.value);
        System.out.println(rootNode.leftChild.rightChild.value);
        System.out.println(rootNode.rightChild.leftChild.value);
        System.out.println(rootNode.rightChild.rightChild.value);
        return rootNode;
    }

    // instance method on node, takes an array and sets the nodes value from the array's center value,
    // and sends left side to its left child, and the right side to the right child
    private static Node makeNodeFromArray(int[] array) {

        if (array.length == 0) { return null; }

        int centerIndex = getCenterIndex(array);
        Node newNode = new Node(array[centerIndex]);

        // Recurse left
        int[] leftArray = Arrays.copyOfRange(array,0, centerIndex);
        newNode.leftChild = makeNodeFromArray(leftArray);

        // Recurse right
        int[] rightArray = Arrays.copyOfRange(array, centerIndex+1, array.length);
        newNode.rightChild = makeNodeFromArray(rightArray);

        return newNode;
    }

    // Helpers

    private static int getCenterIndex(int[] array) {
        return array.length/2;
    }

}