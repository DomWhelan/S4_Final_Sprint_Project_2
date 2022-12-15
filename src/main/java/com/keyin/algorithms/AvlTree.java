package com.keyin.algorithms;

public class AvlTree extends BinarySearchTree{

    private final int UNBALANCED_RIGHT = -2;
    private final int SLIGHTLY_UNBALANCED_RIGHT = -1;
    private final int UNBALANCED_LEFT = 2;
    private final int SLIGHTLY_UNBALANCED_LEFT = 1;
    private final int BALANCED = 0;

    public AvlTree(){
        super();
    }

    private int getNodeHeight(Node node){
        if(node == null){
            return -1;
        }
        return Math.max(this.getNodeHeight(node.left), this.getNodeHeight(node.right)) +
                1;
    }

    private int getBalanceFactor(Node node){
       return this.getNodeHeight(node.left) - this.getNodeHeight(node.right);
    }

    private Node rotateLeftLeft(Node node){
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    private Node rotateRightRight(Node node){
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    private Node rotateLeftRight(Node node){
        node.left = this.rotateRightRight(node.left);
        return this.rotateLeftLeft(node);
    }

    private Node rotateRightLeft(Node node){
        node.right = this.rotateLeftLeft(node.right);
        return this.rotateRightRight(node);
    }
    public Node InsertNodeAvl(Node node, int value){
        super.insert(node,value);
        int balanceFactor = this.getBalanceFactor(node);
        if(balanceFactor == UNBALANCED_LEFT){
            if(value < node.left.value){
                node = this.rotateLeftLeft(node);
            } else {
                return this.rotateRightLeft(node);
            }
        }
        if(balanceFactor == UNBALANCED_RIGHT){
            if(value > node.right.value){
                node = this.rotateRightRight(node);
            } else {
                return this.rotateRightLeft(node);
            }
        }
        return node;
    }

    public Node removeNode(Node node, int value){
        Node nodeArg = new Node(value);
        node = super.deleteNode(node,nodeArg);
        int balanceFactor = this.getBalanceFactor(node);
        if(balanceFactor == UNBALANCED_LEFT){
            int balanceFactorLeft = getBalanceFactor(node.left);
            if(balanceFactorLeft == SLIGHTLY_UNBALANCED_LEFT || balanceFactorLeft == BALANCED){
                return this.rotateLeftLeft(node);
            }
            if(balanceFactorLeft == SLIGHTLY_UNBALANCED_RIGHT){
                return this.rotateLeftRight(node);
            }
        }
        if(balanceFactor == UNBALANCED_RIGHT){
            int balanceFactorRight = getBalanceFactor(node.right);
            if(balanceFactorRight == SLIGHTLY_UNBALANCED_RIGHT || balanceFactorRight == BALANCED){
                return this.rotateRightRight(node.right);
            }
            if(balanceFactorRight == SLIGHTLY_UNBALANCED_LEFT){
                return this.rotateRightLeft(node.right);
            }
        }
        return node;
    }

}
