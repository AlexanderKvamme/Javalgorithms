package com.company;

public class StackSorter {

    // MARK: Properties

    Stack sortedStack;
    Stack unsortedStack;
    int temp;


    // MARK: Methods

    public Stack sort(Stack providedStack) {

        // set up variables
        this.unsortedStack = providedStack;
        this.sortedStack = new Stack(providedStack.treshold);

        // Loop
        while (unsortedStack.hasValues()) {

            int pops = 0;
            temp = unsortedStack.pop();

            System.out.println("gonna sort: " + temp);

            // pop away
            while (sortedStack.hasValues() && sortedStack.peek() > temp) {
                unsortedStack.push(sortedStack.pop());
                pops++;
            }

            sortedStack.push(temp);

            while (unsortedStack.hasValues() && pops>0) {
                sortedStack.push(unsortedStack.pop());
                pops--;
            }
        }


        // Finally, return a sorted stack
        return sortedStack;
    }

    // MARK: Helpers

}
