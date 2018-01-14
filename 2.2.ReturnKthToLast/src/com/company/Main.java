package com.company;

public class Main {

    public static void main(String[] args) {

        // Make and fill list
        Ll linkedList = new Ll();
        linkedList.addNode(11);
        linkedList.addNode(12);
        linkedList.addNode(13);
        linkedList.addNode(14);
        linkedList.addNode(15);

        linkedList.print();

        // Print a nodes position in comparison to the last node
        Integer test = linkedList.getNodeWithValue(13).kthFromLast();
        System.out.println("kth from last: " + test);

        System.out.println("--------");
        // Print the node that is k positions froßm the last
        Node nodeKthPositionsFromLast1 = linkedList.getNodeKthFromLast(2);
        Node nodeKthPositionsFromLast2 = linkedList.getNodeKthFromLast(3);
        Node nodeKthPositionsFromLast3 = linkedList.getNodeKthFromLast(4);
        Node nodeKthPositionsFromLast4 = linkedList.getNodeKthFromLast(5);
        Node nodeKthPositionsFromLast5 = linkedList.getNodeKthFromLast(6);
    }
}
