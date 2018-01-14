package com.company;

public class Main {

    public static void main(String args[]) {
        try {
            String s = null;
            System.out.println(s.length());
        } catch (Exception e) {
            System.out.println("Catch runtime exception but not quite sure what to do with it");
        }

        System.out.println("Reached here even after uncatched Exception");
    }

}
