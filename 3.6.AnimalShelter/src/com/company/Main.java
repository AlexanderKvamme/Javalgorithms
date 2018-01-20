package com.company;

public class Main {

    public static void main(String[] args) {

        // Katter
        Cat cat1 = new Cat("pus 1");
        Cat cat2 = new Cat("pus 2");
        Cat cat3 = new Cat("pus 3");

        // Hunder
        Dog dog1 = new Dog("Snoop 1");
        Dog dog2 = new Dog("Snoop 2");
        Dog dog3 = new Dog("Snoop 3");

        // Shelter
        AnimalShelter shelter = new AnimalShelter();

        // Push an animal, which waits for a few milliseconds and therefore must catch
        try {
            shelter.pushAnimal(cat1);
            shelter.pushAnimal(dog1);
            shelter.pushAnimal(cat2);
            shelter.pushAnimal(dog2);
            shelter.pushAnimal(cat3);
            shelter.pushAnimal(dog3);
        } catch (InterruptedException e){
            System.out.println(e.toString());
        }

        // Print and pop animals
        while (shelter.hasValues()) {
            Animal a = shelter.pop(AnimalType.ANY);
            a.print();
        }
    }
}
