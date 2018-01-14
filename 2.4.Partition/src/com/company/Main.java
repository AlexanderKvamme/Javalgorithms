package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("Whats up");

        // Make and fill list
        Ll linkedList = new Ll();
        linkedList.addNode(5);
        linkedList.addNode(2);
        linkedList.addNode(5);
        linkedList.addNode(4);
        linkedList.addNode(3);
        linkedList.addNode(1);
        linkedList.print();

        System.out.println("-----");

        // Separate
        linkedList.partition2(3);
        System.out.println("-----After sort:");
        linkedList.print();
    }
}
