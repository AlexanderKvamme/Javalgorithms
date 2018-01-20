package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("would print");

        Node a1 = new Node("a1");
        Node a2 = new Node("a2");
        Node a3 = new Node("a3");
        Node a4 = new Node("a4");
        Node b1 = new Node("b1");
        Node b2 = new Node("b2");
        Node c1 = new Node("c1");
        Node c2 = new Node("c2");

        // List A
        Ll listA = new Ll();
        listA.addNode(a1);
        listA.addNode(a2);
        listA.addNode(a3);
        listA.addNode(a4);

        // List b
        Ll listB = new Ll();
        listB.addNode(b1);
        listB.addNode(b2);

        // List c
        Ll listC = new Ll();
        listC.addNode(c1);
        listC.addNode(c2);

        // Print
        listA.print();
        listB.print();
        listC.print();

        // Fixme: Connect them

        listA.tail.next = listC.head;
        listA.tail = listC.tail;
        listB.tail.next = listC.head;
        listB.tail = listC.tail;

        /*
        *
        *  --- Connect ---
        *          __
        * a1 -> a2   \
        *             >-> c1 -> c2
        * b1 -> b2 __/
        *
        * -------------------
        *
        *  They will then individually look like this
        *
        * a1 -> a2 -> c1 -> c2
        *
        *  And the other one
        *
        * b1 -> b2 -> c1 -> c2
        *
        * --------------------
        * */

        // Connect lists

        // Expected result = c1

        System.out.println("\nlistA___");
        listA.print();

        System.out.println("\nlistB___");
        listB.print();

        Node intersectingNode = listA.intersectingNode(listB);
        System.out.println("resulting node: " + intersectingNode.character);

        Node result = listA.intersectingNodeByComparingTailes(listB);
        System.out.println("resulting node: " + result.character);
    }
}
