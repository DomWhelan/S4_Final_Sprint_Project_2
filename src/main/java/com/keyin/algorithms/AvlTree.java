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

    public int getBalanceFactor(Node node){
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
        node.right = temp.left; //temp.right
        temp.left = node; // node = node.left, temp = node
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

    @Override
    public void insert(int value){
        this.root = insertNodeAvl(root,value);
    }
    public Node insertNodeAvl(Node node, int value){
        node = super.insert(node,value);
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

    public Node removeNodeAVL(Node root, int value){
        root = super.deleteNode(root,value);
        if (root == null){
            return null;
        }
        int balanceFactor = this.getBalanceFactor(root);
        if(balanceFactor == UNBALANCED_LEFT){
            int balanceFactorLeft = getBalanceFactor(root.left);
            if(balanceFactorLeft >= SLIGHTLY_UNBALANCED_LEFT || balanceFactorLeft == BALANCED){
                return this.rotateLeftLeft(root);
            }
            if(balanceFactorLeft == SLIGHTLY_UNBALANCED_RIGHT){
                return this.rotateLeftRight(root.left);
            }
        }
        if(balanceFactor == UNBALANCED_RIGHT){
            int balanceFactorRight = getBalanceFactor(root.right);
            if(balanceFactorRight <= SLIGHTLY_UNBALANCED_RIGHT || balanceFactorRight == BALANCED){
                return this.rotateRightRight(root);
            }
            if(balanceFactorRight == SLIGHTLY_UNBALANCED_LEFT){
                return this.rotateRightLeft(root.right);
            }
        }
        return root;
    }

}
