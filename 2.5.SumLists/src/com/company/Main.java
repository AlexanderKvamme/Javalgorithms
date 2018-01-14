package com.company;

public class Main {

    public static void main(String[] args) {

        /*
        // Expected result: 4642
        Ll list1 = new Ll();
        list1.addNode(3);
        list1.addNode(2);
        list1.addNode(1);

        Ll list2 = new Ll();
        list2.addNode(4);
        list2.addNode(3);
        list2.addNode(2);
        list2.addNode(1);
        */

        /*
        // Expected result: 2 -> 1 -> 9
        Ll list1 = new Ll();
        list1.addNode(7);
        list1.addNode(1);
        list1.addNode(6);

        Ll list2 = new Ll();
        list2.addNode(5);
        list2.addNode(9);
        list2.addNode(2);
        */

        /*
        // Sort in forward order

        Ll list1 = new Ll();
        list1.addNode(6);
        list1.addNode(1);
        list1.addNode(7);

        Ll list2 = new Ll();
        list2.addNode(2);
        list2.addNode(9);
        list2.addNode(5);

        // Sum two linked lists
        System.out.println("Expecting: 9 -> 1 -> 2");
        Ll resultList = combineListsInForwardOrder(list1, list2); // Expected result: 9 -> 1 -> 2
        */

        // Sort in forward order

        Ll list1 = new Ll();
        list1.addNode(9);
        list1.addNode(5);
        list1.addNode(4);
        list1.addNode(3);
        list1.addNode(2);
        list1.addNode(1);

        Ll list2 = new Ll();
        list2.addNode(5);
        list2.addNode(4);
        list2.addNode(3);
        list2.addNode(2);
        list2.addNode(1);

        // Sum two linked lists
        System.out.println("Expecting: 1 -> 0 -> 0 -> 8 -> 6 -> 4 -> 2");
        Ll resultList = combineListsInForwardOrder(list1, list2);

        // Print summary
        System.out.println("--------_\nPRINTING COMBINED LIST:");
        resultList.print();
    }


    // Combine when stored in forward order:

    public static Ll combineListsInForwardOrder(Ll listA, Ll listB) {

        // Recursively sums the two lists in paralell with a recursive function that returns the remainder.

        int aLength = listA.getLength();
        int bLength = listB.getLength();

        // Balance number of nodes in both lists
        if (aLength>bLength) {
            listB.addInFront(0);
        } else if (bLength > aLength) {
            listA.addInFront(0);
        }

        // Lists are now balanced, Start combining
        Ll combinedList = new Ll();

        if (recurseCombine(listA.head, listB.head, combinedList) == 1) {
            // Recursion returns a remainder, so add a node
            Node newNode = new Node(1);
            combinedList.addInFront(1);
        }

        return combinedList;
    }

    // The recursive forward combining

    public static int recurseCombine(Node nodeA, Node nodeB, Ll resultList) {

        // recurse till end, sum, and return any remainder

        // No next node to sum
        if (nodeA.next == null && nodeB.next == null) {
            int combinedValue = nodeA.value + nodeB.value;
            if (combinedValue >= 10) {
                Node newNode = new Node(combinedValue - 10);
                System.out.println("end returning 1, and storing sum: " + newNode.value);
                resultList.addNode(newNode);
                return 1;
            } else {
                Node newNode = new Node(combinedValue);
                System.out.println("end returning 0, and storing sum: " + newNode.value);
                resultList.addNode(newNode);
                return 0;
            }
        }

        // Is not the last nodes, so make new resultNode and summarize it
        int newSum = nodeA.value + nodeB.value + recurseCombine(nodeA.next, nodeB.next, resultList);


        if (newSum >= 10) {
            System.out.println("MID became " + newSum + "... returning 1" + " , and storing sum: " + (newSum-10));
            resultList.addInFront(newSum - 10);
            return 1;
        } else {
            System.out.println("MID became " + newSum + "... returning 0" + " , and storing sum: " + newSum);
            resultList.addInFront(newSum);
            return 0;
        }
    }

    // First part


    public static Ll combineLists(Ll listA, Ll listB) {

        int aLength = listA.getLength();
        int bLength = listB.getLength();

        System.out.println("lengthA: " + aLength);
        System.out.println("lengthB: " + bLength);

        // balance number of nodes in both lists
        if (aLength>bLength) {
            // add 0 to b
            listB.addInFront(0);
        } else if (bLength > aLength) {
            // addd 0 to a
            listA.addInFront(0);
        }

        // Make new list to store results in
        Ll combinedList = new Ll();

        Node currentA = listA.head;
        Node currentB = listB.head;

        // Recursively loop through listA and listB and combine
        // Recursion returns any remainder

        int remainder = 0;

        while (currentA != null && currentB != null) {
            System.out.println("would combine: " + currentA.value + " and " + currentB.value);

            int newValue = currentA.value + currentB.value + remainder;

            if (newValue < 10) {
                remainder = 0;
                combinedList.addNode(newValue);
            } else {
                // FIXME
                remainder = 1;
                combinedList.addNode(newValue-10);
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }

        System.out.println("had remainder: " + remainder);

        System.out.println("---");
        combinedList.print();

        return null;
    }

}
