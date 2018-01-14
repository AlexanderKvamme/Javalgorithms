package com.company;

public class Main {

    public static void main(String[] args) {

        // Generate a linked list
        Ll linkedList = new Ll();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);
        linkedList.addNode(5); // Dupe
        linkedList.addNode(6);

        // operate on it
        linkedList.removeDuplicates();
        linkedList.print();

        // try again without a buffer

        // linkedList.removeDuplicatesWithoutExtraBuffer();
        // linkedList.print();
    }

}
