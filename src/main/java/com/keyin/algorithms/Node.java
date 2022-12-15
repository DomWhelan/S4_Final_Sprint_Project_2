package com.keyin.algorithms;

public class Node {

    protected int value;
    protected Node left;
    protected Node right;

    protected int height;

    public Node(int value){
        this.value = value;
        left = null;
        right = null;
        height = 1;
    }
}
