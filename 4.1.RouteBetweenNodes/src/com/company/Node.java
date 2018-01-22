package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Node {

    // MARK: Properties

    public String name;
    public HashSet<Node> friends;
    private boolean visited = false;

    // MARK: Constructor

    public Node(String name) {
        this.name = name;
        this.friends = new HashSet<Node>();
    }

    // MARK: Methods

    public void addFriend(Node n) {
        friends.add(n);
    }

    public void addFriends(Node[] friends) {
        for (Node friend : friends) {
            this.friends.add(friend);
        }
    }

    // Algorithm

    // Public method to trigger the BFS from main
    public boolean hasRouteToBFS(Node targetNode) {


        // Her er det kanskje best med en bidirectional search, men jeg begynner med en breadth first
        if (targetNode == this) { return true; }

        this.visited = true;

        LinkedList<Node> nodesToVisit = new LinkedList<>();

        for (Node friend : this.friends) {
            nodesToVisit.add(friend);
        }

        return hasRouteTo(targetNode, nodesToVisit);
    }

    // private method to keep iterating down the levels
    private boolean hasRouteTo(Node targetNode, LinkedList<Node> nodesToVisit) {

        ArrayList<Node> visitedNodes = new ArrayList<>();

        while (!nodesToVisit.isEmpty()) {
            Node node = nodesToVisit.pop();

            if (node.visited) {
                continue; }

            if (node == targetNode) {

                // Reset visitedlist
                for (Node n : visitedNodes) {
                    n.visited = false;
                }

                visitedNodes.forEach(a -> a.visited = false);
                return true;
            }

            node.visited = true;
            visitedNodes.add(node);

            for (Node friend : node.friends) {
                nodesToVisit.add(friend);
            }
        }

        // Reset visitedlist
        visitedNodes.forEach(a -> a.visited = false);

        return false;
    }
}
