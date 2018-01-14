package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Ll isPalindrome = new Ll();
        isPalindrome.addNode('a');
        isPalindrome.addNode('b');
        isPalindrome.addNode('b');
        isPalindrome.addNode('a');

        Ll isPalindrome2 = new Ll();
        isPalindrome2.addNode('a');
        isPalindrome2.addNode('b');
        isPalindrome2.addNode('c');
        isPalindrome2.addNode('b');
        isPalindrome2.addNode('a');

        Ll isNotPalindrome = new Ll();
        isNotPalindrome.addNode('a');
        isNotPalindrome.addNode('b');
        isNotPalindrome.addNode('X');
        isNotPalindrome.addNode('a');


        Ll isNotPalindrome2 = new Ll();
        isNotPalindrome2.addNode('s');
        isNotPalindrome2.addNode('h');
        isNotPalindrome2.addNode('a');
        isNotPalindrome2.addNode('b');
        isNotPalindrome2.addNode('a');
        isNotPalindrome2.addNode('z');
        isNotPalindrome2.addNode('a');

        /*
        // Iterative te
        System.out.println("---\nRESULT: " + isPalindromeIterative(isPalindrome) + "\n"); // true
        System.out.println("---\nRESULT: " + isPalindromeIterative(isPalindrome2) + "\n"); // false
        System.out.println("---\nRESULT: " + isPalindromeIterative(isNotPalindrome) + "\n"); // false
        System.out.println("---\nRESULT: " + isPalindromeIterative(isNotPalindrome2) + "\n"); // false*/

        // Recursive tests
        System.out.println("---\nRESULT: " + isPalindrome.isPalindromeRecursive()+ "\n"); // true
        System.out.println("---\nRESULT: " + isPalindrome2.isPalindromeRecursive() + "\n"); // false
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---\nRESULT: " + isNotPalindrome.isPalindromeRecursive() + "\n"); // false
        System.out.println("---\nRESULT: " + isNotPalindrome2.isPalindromeRecursive() + "\n"); // false
    }
















    public static boolean isPalindromeEndsToMid(Ll linkedlist) {

        Node runner = linkedlist.tail;
        Node walker = linkedlist.head;

        while (runner.character == walker.character) {
            if (runner == walker || walker.next == runner) {
                // Mid is reached
                return true;
            } else {
              runner = runner.previous;
              walker = walker.next;
            }
        }

        return false;
    }

    public static boolean isPalindromeIterative(Ll linkedlist) {

        Node walker = linkedlist.head;
        Node runner = linkedlist.head.next;

        Stack<Character> stack = new Stack<Character>();

        while ( runner != null && runner.next != null ) { // Depending on odd or even
            System.out.println("walker: " + walker.character);
            System.out.println("runner: " + runner.character);
            System.out.println("Pushing: " + walker.character);
            System.out.println();

            stack.push(walker.character);

            walker = walker.next;
            runner = runner.next.next;
        }

        // Now at end

        if (runner == null) { // odd
            System.out.println("is odd");
            walker = walker.next;
        } else if (runner.next == null) {
            System.out.println("is even");
            stack.push(walker.character);
            walker = walker.next;
        }

        // Pop til empty

        while (!stack.empty() && walker != null) {
            Character test = stack.peek();
            System.out.println( walker.character + " equal to " + stack.pop() + "?");
            if (test != walker.character) {
                return false;
            }
            walker = walker.next;
        }

        return true;
    }
}
