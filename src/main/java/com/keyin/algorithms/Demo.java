package com.keyin.algorithms;


import com.keyin.cli.Interface;
import com.keyin.utlilities.JsonConverter;
import com.keyin.utlilities.JsonWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Node;

public class Demo {

    public static void main(String[] args) {

        BinarySearchTree BST = new BinarySearchTree();

        BST.insert(3);
        BST.insert(2);
        BST.insert(5);
        BST.insert(8);
        BST.insert(1);
        BST.insert(7);
        BST.insert(11);
        BST.insert(20);
        BST.insert(6);
        BST.insert(22);
        BST.insert(62);

        AvlTree AVL = new AvlTree();

        AVL.insertAVL(3);
        AVL.insertAVL(2);
        AVL.insertAVL(5);
        AVL.insertAVL(8);
        AVL.insertAVL(1);
        AVL.insertAVL(7);
        AVL.insertAVL(11);
        AVL.insertAVL(20);
        AVL.insertAVL(6);
        AVL.insertAVL(22);
        AVL.insertAVL(62);

        JsonConverter toJson = new JsonConverter();
        JsonWriter writer = new JsonWriter();

        System.out.println(AVL.getBalanceFactor(BST.root));

        System.out.println(AVL.getBalanceFactor(AVL.root));

        JSONObject output = toJson.convertTreeToJsonObject(AVL.root);

        System.out.println(output);

        writer.display(output);
    }
}
