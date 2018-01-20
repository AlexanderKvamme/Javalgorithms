package com.company;

// Singly linked list

import java.util.HashSet;
import java.util.Set;

public class Ll {

    // MARK: Properties

    Node head = null;
    Node tail = null;

    // MARK: Methods

    // Intersecting

    // Try 1: iterate over both and add to set
    Node intersectingNode(Ll secondList) {

        Set<Node> nodeSet;
        nodeSet = new HashSet<Node>();

        Node currA = head;
        Node currB = secondList.head;

        while (currA != null || currB != null) {

            if (currA != null) {
                if (nodeSet.contains(currA)) {
                    return currA;
                } else {
                    nodeSet.add(currA);
                }
                currA = currA.next;
            }

            if (currB != null) {
                if (nodeSet.contains(currB)) {
                    return currB;
                } else {
                    nodeSet.add(currB);
                }
                currB = currB.next;
            }
        }
        return null;
    }

    // Try 2: Check tailes first
    Node intersectingNodeByComparingTailes(Ll secondList) {

        // Tail must match
        if (tail != null && secondList.tail != null) {
            if(tail != secondList.tail) {
                return null;
            }
        }

        int lengthA = getCount();
        int lengthB = secondList.getCount();
        int diff = Math.abs(lengthA-lengthB);

        Node currA = head;
        Node currB = secondList.head;

        // Skip past any difference in length, since the two paths must merge at equal length from that node.
        if (lengthA < lengthB ) {
            for(int i = 0; i < diff; i++) {
                currB = currB.next;
            }
        } else if (lengthA > lengthB) {
            for(int i = 0; i < diff; i++) {
                currA = currA.next;
            }
        }

        // Compare nodes in pairs until match is found
        while(currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }

        return currA;
    }


    public void addNode(String i) {

        Node newNode = new Node(i);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void addNode(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
            node.next = null;
        }
    }

    public int getCount() {
        int i = 0;

        Node curr = head;
        while (curr != null) {
            i++;
            curr = curr.next;
        }
        return i;
    }

    // Recursively reverse list, by initially receiving a headnode
    public Node recursivelyReverse(Node current) {
        if (current == null) { return null; }

        else if (current.next == null) {
            head = current; // last item should become first when its reversed
            return current; // Single last item reach, this is its own reverse
        } else {
            Node followingNode = current.next; // used to send into reverse(nextLine)

            Node rightSideReversed = recursivelyReverse(followingNode); // returnerer siste node i den reverserte høyredelen (4), du skal legge 3 til ETTER denne
            current.next = null;
            rightSideReversed.next = current;

            tail = current;

            return current;
        }
    }

    public void print() {

        if (listIsEmpty()) {
            System.out.println("List was empty");
            return;
        }

        Node node = head;

        // iterate through
        while (node != null) {
            System.out.println(" - " + node.character);
            node = node.next;
        }
    }

    public void makeHead(Node n) {
        head = n;
    }

    public void makeTail(Node n) {
        tail = n;
    }

    // Helpers

    private boolean listIsEmpty() {
        return head == null;
    }

    private boolean listHasOneNode() {
        return head.next == null;
    }
}
