package com.keyin.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AvlTreeTest {

    @Test
    public void avlBalanceTest(){

        AvlTree avl = new AvlTree();
        avl.insert(10);
        avl.insert(5);
        avl.insert(15);
        avl.insert(20);

        avl.preorder();
        System.out.println();

        // Confirm that root value is currently 10
        Assertions.assertEquals(10,avl.root.value);

        // confirm the current balance
        Assertions.assertEquals(-1,avl.getBalanceFactor(avl.root));

        avl.insert(25);

        // Once value 25 was added the tree was unbalanced (-2)
        // Confirm that the tree rotated to correct
        Assertions.assertEquals(15,avl.root.value);

        avl.insert(2);
        avl.insert(1);
        avl.insert(3);

        // Now lets test if the tree auto balances on deletion
        avl.root = avl.removeNodeAVL(avl.root,20);
        avl.root = avl.removeNodeAVL(avl.root,25);

        // The balance would be -2 without rotation
        // With rotation balance should be 0 and the root value 5
        System.out.println(avl.getBalanceFactor(avl.root));
        Assertions.assertEquals(0,avl.getBalanceFactor(avl.root));
        Assertions.assertEquals(5,avl.root.value);
    }
}
