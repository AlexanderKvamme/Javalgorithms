package com.HomeOfficesInternational;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException{

        Matrix initialMatrix = new Matrix(4);
        initialMatrix.printBetter();
        initialMatrix.rotate();
        initialMatrix.printBetter();

        /*
        // Make copy to rotate and compare results
        Matrix clone = (Matrix)initialMatrix.clone();

        System.out.printf("\n\nROTATING COMPLETE: ");
        clone.rotateBetter();
        clone.printBetter();
        initialMatrix.printBetter();
        */
    }
}