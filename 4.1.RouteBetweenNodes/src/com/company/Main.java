package com.company;

import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // Make some friends
        Node bizz = new Node("Alexander");
        Node kz = new Node("Eivind Kåset");
        Node byzz = new Node("Even Tesdal");
        Node eppi = new Node("Espen");
        Node hkon = new Node("Håkon Roal");
        Node trini = new Node("Trini");
        Node jorgen = new Node("Jørgen");
        Node henrik = new Node("Henrik");
        Node ruus = new Node("Ruus");
        Node nina = new Node("Nina");
        Node heine = new Node("Heine");

        // big graph
        bizz.addFriends(new Node[]{ kz, byzz, eppi});
        eppi.addFriend(hkon);
        hkon.addFriend(trini);
        kz.addFriends(new Node[] { jorgen, henrik});
        henrik.addFriend(ruus);
        jorgen.addFriend(ruus);

        // ny subgraph
        nina.addFriend(heine);

        // expected: true true true, false false false
        System.out.println(nina.hasRouteToBFS(heine));
        System.out.println(bizz.hasRouteToBFS(byzz));
        System.out.println(bizz.hasRouteToBFS(ruus));
        System.out.println(nina.hasRouteToBFS(ruus));
        System.out.println(bizz.hasRouteToBFS(nina));
        System.out.println(bizz.hasRouteToBFS(nina));
    }
}
