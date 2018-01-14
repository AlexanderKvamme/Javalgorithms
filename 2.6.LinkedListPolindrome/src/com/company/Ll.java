package com.company;

// Singly linked list

public class Ll {

    // MARK: Properties

    Node head = null;
    Node tail = null;

    // MARK: Methods


    // MARK: Recursive

    // Class used to return multiple return values like a tuple

    public boolean isPalindromeRecursive() {
        System.out.println("Would check: ");
        print();

        // If list is composed of either 1 or 0 items, its already a palindrome
        if (getCount() < 2) {
            return true;
        }

        RecursionResult result = recurse(head, getCount()-2);

        return result.wasEqual;
    }

    static RecursionResult recurse(Node node, int pos) {

        // This if evaluation is only triggerd on the node before the mid node. If its an odd LinkedList, it will then skip the center node (while returning true), and if its an even LinkedList,
        // it will return  2 ?? 3 if the list is (1) -> (2) -> (3) -> (4)

        // Return the node

        if (pos == 0) {
            // Even: Calculate return, from the two center nodes
            RecursionResult initialResult = new RecursionResult();
            initialResult.node = node.next.next; //
            initialResult.wasEqual = node.character == node.next.character;
            return initialResult;
        } else if (pos == 1) {
            // Odd: Calculate return, but skip the center node
            RecursionResult initialResult = new RecursionResult();
            initialResult.wasEqual = true;
            initialResult.node = node.next.next.next;
            return initialResult;
        }

        // New Recursion
        RecursionResult result = recurse(node.next, pos-2);

        /* Making it this far means the base case is already evaluated, and we are comparing the current node with the result on our way back up the recursion
           If result was false, propagate false upwards*/

        if (result.wasEqual == false) {
            return new RecursionResult(null, false);
        } else {
            // If result was true, check also the next pairs upwards
            return new RecursionResult(result.node.next, (node.character == result.node.character));
        }
    }

    public void addNode(char i) {

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
