package com.sandip;
import java.util.*;

class Node {
    Node parent;
    int value;

    Node(int value) {
        this.parent = this;
        this.value = value;
    }
}

public class DisjointSet {
    // You can add methods and properties here
    List<Node> nodes = new ArrayList<>();

    DisjointSet(int n) {
        for (int i=0; i<n; i++) {
            nodes.add(new Node(i));
        }
    }
}