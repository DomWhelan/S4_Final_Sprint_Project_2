package com.keyin.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NodeTest {

    @Test
    public void NodeConstructorTest(){

        Node testNode1 = new Node();

        Assertions.assertEquals(testNode1.value,0);
        Assertions.assertNull(testNode1.left);
        Assertions.assertNull(testNode1.right);

        Node testNode2 = new Node(5);

        Assertions.assertEquals(testNode2.value,5);
        Assertions.assertNull(testNode2.left);
        Assertions.assertNull(testNode2.right);

    }
}
