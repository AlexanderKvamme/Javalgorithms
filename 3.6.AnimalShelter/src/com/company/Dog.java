package com.company;

import java.util.Date;

public class Dog implements Animal {

    // MARK: Properties

    private String name;
    private AnimalType animalType;
    private Date dateSubmitted = null;

    // MARK: Constructor

    public Dog(String name) {
        this.name = name;
        this.animalType = AnimalType.DOG;
    }

    // MARK: Methods

    // Interface conformance

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getArrivalDate() {
        return dateSubmitted;
    }

    @Override
    public void setArrivalDate(Date date) {
        dateSubmitted = date;
    }

    @Override
    public AnimalType getType() {
        return animalType;
    }

    @Override
    public void print() {
        System.out.println(name + " is a dog.");
    }
}
