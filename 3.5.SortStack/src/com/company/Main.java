package com.company;

public class Main {

    public static void main(String[] args) {

        StackSorter stackSorter = new StackSorter();

        // Make unsorted stack
        Stack unsortedStack = new Stack(10);
        unsortedStack.push(1);
        unsortedStack.push(9);
        unsortedStack.push(2);
        unsortedStack.push(40);
        unsortedStack.push(3);
        unsortedStack.push(99);
        System.out.println("Sorted stack:");
        unsortedStack.printStack();

        // Sort unsorted stack
        Stack sortedStack = stackSorter.sort(unsortedStack);
        System.out.println("Sorted stack:");
        sortedStack.printStack();
    }
}
