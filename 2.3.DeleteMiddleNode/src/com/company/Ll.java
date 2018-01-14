package com.company;

import java.util.ArrayList;

// Singly linked list

public class Ll {

    // MARK: Properties

    ArrayList<Node> linkedList = new ArrayList<Node>();
    Node head = null;
    Node tail = null;

    // MARK: Methods

    public void addNode(int i) {

        Node newNode = new Node(i);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Node getNode(int i) {
        System.out.println("gonna get node with value: " + i);
        Node current = head;

        while (current != null) {
            if (current.value == i) {
                System.out.println("returning: " + current.value );
                return current;
            }
            current = current.next;
        }
        System.out.println("returning: null" );
        return null;
    }

    public void deleteNode(Node n) {

        Node runner = n;
        Node current = head;

        while (current.next != n) {
            current = current.next;
        }

        // current is now the node before n
        current.next = runner.next;
    }

    public void deleteNodeWithoutAccessToHead(Node n) {

        if (n.next == null) { return; }

        Node next = n.next;

        // Swap values with next node and delete the one you swapped to

        n.value = next.value;
        // Delete the 'next' node
        n.next = next.next;

    }

    public void deleteNodeWithValue(Integer v) {

        // If no next, delete if this only node is the same value
        if (head.next == null) {
            if (head.value == v) {
                head = null;
            }
        }

        // If initial node should be deleted
        if (head.value == v) {
            head = head.next;
        }

        // Guaranteed to have a next
        Node current = head;
        Node runner = head.next;

        while (runner != null) {

            if (runner.value == v) {
                current.next = runner.next;
            }

            current = current.next;
            runner = runner.next;
        }

    }

    public void print() {

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
