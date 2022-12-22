package com.keyin.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    @Test
    public void BstConstructorTest(){

        BinarySearchTree testBst = new BinarySearchTree();
        Assertions.assertNull(testBst.root);
    }

    @Test
    public void insertTest(){

        BinarySearchTree testBstTree = new BinarySearchTree();

        testBstTree.insert(5);
        testBstTree.insert(8);
        testBstTree.insert(6);
        testBstTree.insert(4);
        testBstTree.insert(1);

        // Confirm desired behaviour on insert method
        Assertions.assertEquals(5,testBstTree.root.value);
        Assertions.assertEquals(8,testBstTree.root.right.value);
        Assertions.assertEquals(6,testBstTree.root.right.left.value);
        Assertions.assertEquals(4,testBstTree.root.left.value);
        Assertions.assertEquals(1,testBstTree.root.left.left.value);
    }

    @Test
    public void deleteANodeTest(){

        BinarySearchTree testDeleteTree = new BinarySearchTree();

        Assertions.assertNull(testDeleteTree.deleteNode(testDeleteTree.root,4));

        testDeleteTree.insert(4);
        testDeleteTree.insert(3);
        testDeleteTree.insert(6);

        testDeleteTree.preorder(testDeleteTree.root);

        // Confirm root value
        Assertions.assertEquals(4,testDeleteTree.root.value);

        testDeleteTree.deleteANode(4);
        System.out.println();
        testDeleteTree.preorder();

        // Confirm deletion
        Assertions.assertNotEquals(4,testDeleteTree.root.value);
        // Confirm root replacement
        Assertions.assertEquals(6,testDeleteTree.root.value);
        Assertions.assertNull(testDeleteTree.root.right);

    }

    @Test
    public void searchTest(){

        BinarySearchTree searchTestTree = new BinarySearchTree();
        searchTestTree.insert(8);
        searchTestTree.insert(12);
        searchTestTree.insert(4);
        searchTestTree.insert(2);
        searchTestTree.insert(16);
        searchTestTree.insert(3);

        Assertions.assertFalse(searchTestTree.search(15));
        Assertions.assertTrue(searchTestTree.search(16));

    }

}
