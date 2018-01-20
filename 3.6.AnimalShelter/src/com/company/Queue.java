package com.company;

import java.util.Date;
import java.util.EmptyStackException;

public class Queue {

    // MARK: Properties

    QueueNode frontNode; // last in
    QueueNode backNode; // first in

    int count = 0;

    // MARK: Methods

    public void push(QueueNode node) {
        if (isEmpty()) {
            // Add to front and back
            frontNode = node;
            backNode = node;
        } else {
            // Add to back
            backNode.nextNode = node;
            backNode = node;
        }
        count++;
    }

    public Animal peek() {
        if (isEmpty()) { return null; }

        return frontNode.getAnimal();
    }

    public Animal pop() {

        Animal animalToReturn = null;

        if (isEmpty()) {
            return null;
        } else if (count == 1) {
            animalToReturn = frontNode.getAnimal();
            frontNode = null;
            backNode = null;
        } else {
            // Has multiple nodes
            animalToReturn = frontNode.getAnimal();
            frontNode = frontNode.nextNode;
        }

        count--;
        return animalToReturn;
    }

    public Date dateOfAnimalFirstInLine() {
        if (frontNode == null || frontNode.getAnimal() == null ||frontNode.getAnimal().getArrivalDate() == null) {
            throw new EmptyStackException();
        }

        return frontNode.getAnimal().getArrivalDate();
    }

    public void printQueue() {
        System.out.println("Printing Queue: ");

        QueueNode curr = frontNode;

        while (curr != null) {
            System.out.println(" - " + curr.getAnimal().getName());
            curr = curr.nextNode;
        }
    }

    // Helpers

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean hasValues() {
        return count > 0;
    }

}
