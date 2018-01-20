package com.company;

public class ArrayStack {

    int stackCount = 0;

    Character[][] allArrays = null;

    public ArrayStack(int stackCount) {

        this.stackCount = stackCount;

        // Array 1, 2 and 3
        for (int a = 1; a <= stackCount; a++) {
            // Make three 'stacks'
            allArrays = new Character[3][elementsInEachArray];
        }

        // Construction print
        System.out.println("made char array with " + elements + " elements, divided by " + stackCount);
    }

    // MARK: Stack methods

    // Push
    // Pop
    // Peek
    // isEmpty

    // Helpers

    int arrayFirstIndex(int n) {
        return (n-1) * stackCount;
    }

    int arrayLastIndex(int n) {
        return arrayFirstIndex(n) + stackCount - 1;
    }

    void printStack() {
        for (Character[] a: allArrays) {
            for (Character c: a) {
                if (c == null) {
                    System.out.println("null");
                } else {
                    System.out.println(c);
                }
            }
        }
        System.out.println("did print stack");
    }
}
