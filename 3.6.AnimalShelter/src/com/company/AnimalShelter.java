package com.company;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AnimalShelter {

    Queue dogQueue;
    Queue catQueue;

    public AnimalShelter() {
        this.catQueue = new Queue();
        this.dogQueue = new Queue();
    }

    public void pushAnimal(Animal animal) throws InterruptedException {

        Thread.sleep(10);
        animal.setArrivalDate(new Date());
        AnimalType type = animal.getType();

        // Add to dog/cat node
        if (type == AnimalType.DOG) {
            QueueNode dogNode = new QueueNode(animal);
            dogQueue.push(dogNode);
        } else if (type == AnimalType.CAT) {
            QueueNode catNode = new QueueNode(animal);
            catQueue.push(catNode);
        }
    }

    public Animal pop(AnimalType type) {

        // Decide animal to return
        if (type == AnimalType.CAT) {
            // pop cat
            return catQueue.pop();
        } else if (type == AnimalType.DOG) {
            // Pop a dog
            return dogQueue.pop();
        }

        // If neither cat or dog, the return dog or cat based on when they arrived shelter, pop dog or cat depending on which was delivered first
        if (dogQueue.hasValues() && catQueue.hasValues()) {
            if (dogQueue.dateOfAnimalFirstInLine().before(catQueue.dateOfAnimalFirstInLine())) {
                // Dog was institutionalized before the cat, so pop the dog
                Dog d = (Dog)dogQueue.peek();
                return dogQueue.pop();
            } else {
                // Cat was delivered at the same time or earlier
                Cat c = (Cat)catQueue.peek();
                return catQueue.pop();
            }
        } else { // If one or both queues are empty
            if (dogQueue.isEmpty() && catQueue.isEmpty()) {
                return null;
            } else if (dogQueue.isEmpty()){
                return catQueue.pop();
            } else if (catQueue.isEmpty()){
                return dogQueue.pop();
            }
        }
        return null;
    }

    // Helpers

    public boolean isEmpty() {
        return (catQueue.isEmpty() && dogQueue.isEmpty());
    }

    public boolean hasValues() {
        return !isEmpty();
    }
}
