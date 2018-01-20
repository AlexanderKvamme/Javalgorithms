package com.company;
import java.util.Date;

// MARK: Animals class

public interface Animal {

    String getName();
    Date getArrivalDate();
    void setArrivalDate(Date date);
    AnimalType getType();
    void setName(String name);
    void print();
}


