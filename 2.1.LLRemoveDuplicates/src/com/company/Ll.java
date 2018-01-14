package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

// Singly linked list

public class Ll {

    // MARK: Properties

    ArrayList<Node> linkedList = new ArrayList<Node>();
    Node head = null;
    Node tail = null;

    // MARK: Methods

    public void addNode(int i) {

        Node newNode = new Node(i);
        newNode.owner = this;

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void removeDuplicates() {

        /*
        if (listIsEmpty() || listHasOneNode()) {
            System.out.println("Cant remove from an empty linked list");
            return;
        }

        Hashtable<Integer, Integer> valueCountTable = new Hashtable<Integer, Integer>();

        Node node = head;

        while (node.next != null) {

            Node nextNode = node.next;

            if (valueCountTable.get(node.value) != null) {
                // Has a value
                if (valueCountTable.get(node.value) < 1) {
                    valueCountTable.put(node.value, 1);
                } else {
                    node.delete();
                }
            } else { // Value doesnt exist in table, set value to have count: '0'
                valueCountTable.put(node.value, 1);
            }

            node = nextNode;
        }
        */

        // Improved version using HashSet instead of HashTable/HashMap

        if (listIsEmpty() || listHasOneNode()) {
            System.out.println("Cant remove from an empty linked list");
            return;
        }

        // Make a hashSet, loop through all
        HashSet<Integer> hashSet = new HashSet<Integer>();

        Node node = head;

        while (node.next != null) {
            Node nextNode = node.next;

            if (hashSet.contains(node.value) ){
                node.delete();
            } else {
                hashSet.add(node.value);
            }
            node = nextNode;
        }
        System.out.println("DONE");
    }

    public void removeDuplicatesWithoutExtraBuffer() {
        System.out.println("would remove all duplicates without extra buffer");

        Node firstPointer = head;
        Node secondPointer = head.next;

        while (firstPointer != tail) {
            System.out.println(" - " + firstPointer.value);
            secondPointer = firstPointer.next;
            while (secondPointer != tail) {
                System.out.println(" - - " + secondPointer.value);

                // Delete any match
                if (firstPointer.value == secondPointer.value) {
                    System.out.println(" - - (will remove)");
                    Node nextPointer = secondPointer.next;
                    secondPointer.delete();
                    secondPointer = nextPointer;
                } else {
                    secondPointer = secondPointer.next;
                }
            }

            firstPointer = firstPointer.next;
        }
    }


    public void print() {
        System.out.println("*WOULD PRINT*");

        if (listIsEmpty()) {
            System.out.println("List was empty");
            return;
        }

        Node node = head;

        // iterate through
        while (node.next != null) {
            node.printNode();
            node = node.next;
        }

        node.printNode();
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
