package com.keyin.algorithms;


import org.json.simple.parser.JSONParser;

public class Demo {

    public static void main(String[] args) {

//        BinarySearchTree BST = new BinarySearchTree();

        AvlTree BST = new AvlTree();

        BST.insert(3);
        BST.insert(2);
        BST.insert(5);
        BST.insert(8);
        BST.insert(1);
        BST.insert(7);
        BST.insert(11);


    }
}
