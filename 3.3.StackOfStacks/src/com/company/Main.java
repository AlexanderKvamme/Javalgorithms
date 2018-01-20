package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        StackOfStacks sos = new StackOfStacks(3);
        sos.push(1);
        sos.push(2);
        sos.push(3);
        sos.push(4);
        sos.push(5);
        sos.push(6);
        sos.push(7);
        sos.push(8);
        sos.push(9);

        System.out.println("-- will pop top of stack 2 --");

        sos.popAt(2);
        sos.popAt(2);
        sos.popAt(2);

//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        sos.printStacks();
//
//        System.out.println("-- will pop 5 from topstack and down to the second --");
//        sos.pop();
//        sos.pop();
//        sos.pop();
//        sos.pop();
//        sos.pop();

        sos.printStacks();

    }
}
