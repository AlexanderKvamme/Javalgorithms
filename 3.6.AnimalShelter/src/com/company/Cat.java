package com.company;

import java.util.Date;

public class Cat implements Animal {

    // MAKR: Properties

    private AnimalType animalType;
    private String name;
    private Date dateSubmitted = null;

    // MARK: Constructor

    public Cat(String name) {
        this.name = name;
        this.animalType = AnimalType.CAT;
    }

    // MARK: Methods

    // Interface requirements

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
        System.out.println(name + " is a cat.");
    }
}
