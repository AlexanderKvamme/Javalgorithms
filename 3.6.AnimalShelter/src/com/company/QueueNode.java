package com.company;

public class QueueNode {

    // MARK: Properties

    public QueueNode nextNode;
    private Animal animal;

    // MARK: Constructor

    public QueueNode(Animal a) {
        this.animal = a;
    }

    // MARK: Methods

    public Animal getAnimal() {
        return animal;
    }
}
