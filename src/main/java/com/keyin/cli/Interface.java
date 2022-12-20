package com.keyin.cli;

import com.keyin.algorithms.BinarySearchTree;
import com.keyin.utlilities.JsonConverter;
import com.keyin.utlilities.JsonWriter;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

public class Interface {

    protected final static String AVL_TREE_FILEPATH = "src/main/json/files/AvlTrees.json";
    protected final static String BST_TREE_FILEPATH = "src/main/json/files/BstTrees.json";

    protected static Scanner input = new Scanner(System.in);
    protected static JsonConverter converter = new JsonConverter();
    protected static JsonWriter writer = new JsonWriter();


    private static final String TEXT_GREEN = "\u001B[32m";

    public static void main(String[] args) {

        boolean exit = false;

        displayMenu();

        while(!exit) {
            int choice = input.nextInt();
            if (choice == 0) {
                exit = true;
            }else if (choice < 1 || choice > 2) {
                System.out.println();
                System.err.println("Invalid Selection, Try Again...");
            } else if (choice == 1) {
                createBST();
            } else {
                createAVL();
            }

        }

    }


    private static void displayMenu(){
        System.out.println(TEXT_GREEN + """
                
                Hello User:
                
                Let's implement the use of Binary Search Tree (BST) and
                Adelson, Velskii & Landis Tree (AVL) named after the inventors
                
                Press enter a choice below to continue.....
                
                """.indent(1));

        System.out.println("""
                1. Create BST tree
                2. Create AVL tree
                """);
    }

    private static void createBST(){
        boolean endInput = false;
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        System.out.println("Please enter integers to create BST tree, Enter 0 to end sequence");
        while(!endInput){
            int num = input.nextInt();
            if(num == 0){
                endInput = true;
            } else {
                sequence.add(num);
            }
        }
        BinarySearchTree BST = new BinarySearchTree();
        sequence.forEach(value -> {
            BST.insert(value);
        });
        System.out.println();
        System.out.println("BST tree created, saving to file.......");
        JSONObject treeJsonObject = converter.convertTreeToJsonObject(BST.root);
        writer.addToFile(treeJsonObject, BST_TREE_FILEPATH);
        System.out.println();
        System.out.println("BST tree saved to BstTrees.json");
    }

    private static void createAVL() {
    }
}

