package com.company;

// Singly linked list

public class Ll {

    // MARK: Properties

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

    public void addNode(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
            node.next = null;
        }
    }

    // Short partition method
    public void partition2(int pivot) {
        Node node = head;

        while (node != null) {
            Node next = node.next;

            if (node.value < pivot) {
                // insert as head
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                node = node;
            }
            node = next;
        }
        tail.next = null;
    }

    /*Make two linked lists, one for smaller values, and another for the rest. Merge when done.*/
    public void partition(Integer pivot) {

        Node currentNode = head;

        Ll smallerNodes = new Ll();
        Ll biggerAndEqualNodes = new Ll();

        while (currentNode != null) {

            Node nextNode = currentNode.next;

            if (currentNode.value < pivot) {
                smallerNodes.addNode(currentNode);
            } else {
                biggerAndEqualNodes.addNode(currentNode);
            }
            currentNode = nextNode;
        }

        // Print
        System.out.println("SMALLER:");
        smallerNodes.print();
        System.out.println("BIGGER:");
        biggerAndEqualNodes.print();

        // made two arrays. Add them up
        head = smallerNodes.head;
        tail = biggerAndEqualNodes.tail;
        tail.next = null;;

        smallerNodes.tail.next = biggerAndEqualNodes.head;
        smallerNodes.head = null;

        biggerAndEqualNodes.head = null;
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

    public int getLength() {
        Node current = head;
        int counter = 0;

        while (current != null) {
            counter++;
            current = current.next;
        }

        return counter;
    }

    public void print() {

        if (listIsEmpty()) {
            System.out.println("List was empty");
            return;
        }

        Node node = head;

        // iterate through
        while (node != null) {
            System.out.println(" - " + node.value);
            node = node.next;
        }
    }

    public void addInFront(int i) {
        Node newNode = new Node(i);
        newNode.next = head;
        head = newNode;
    }

    public void addInBack(int i) {
        Node newNode = new Node(i);
        tail.next = newNode;
        tail = newNode;
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
