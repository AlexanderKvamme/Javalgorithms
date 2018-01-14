package com.company;

public class Main {

    public static void main(String[] args) {


        System.out.println("Whats up");


        // Make and fill list
        Ll linkedList = new Ll();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);
        linkedList.print();

        /*
        // Delete a specific node
        System.out.println();
        Node nodeToDelete = linkedList.getNode(13);
        linkedList.deleteNode(nodeToDelete);
        linkedList.print();
        */

        // Delete without having access to head
        System.out.println();
        Node secondNodeToDelete = linkedList.getNode(3);
        linkedList.deleteNodeWithoutAccessToHead(secondNodeToDelete);
        System.out.println("Ended up:");
        linkedList.print();
    }

}
