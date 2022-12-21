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




//    public Node removeNode(Node node, int value){
//        Node nodeArg = new Node(value);
//        node = super.deleteNode(node,value);
//        int balanceFactor = this.getBalanceFactor(node);
//        if(balanceFactor == UNBALANCED_LEFT){
//            int balanceFactorLeft = getBalanceFactor(node.left);
//            if(balanceFactorLeft == SLIGHTLY_UNBALANCED_LEFT || balanceFactorLeft == BALANCED){
//                return this.rotateLeftLeft(node);
//            }
//            if(balanceFactorLeft == SLIGHTLY_UNBALANCED_RIGHT){
//                return this.rotateLeftRight(node.left);
//            }
//        }
//        if(balanceFactor == UNBALANCED_RIGHT){
//            int balanceFactorRight = getBalanceFactor(node.right);
//            if(balanceFactorRight == SLIGHTLY_UNBALANCED_RIGHT || balanceFactorRight == BALANCED){
//                return this.rotateRightRight(node);
//            }
//            if(balanceFactorRight == SLIGHTLY_UNBALANCED_LEFT){
//                return this.rotateRightLeft(node.right);
//            }
//        }
//        return node;
//    }

//    public Node removeNode(Node root, int value) {
//
//        // Find the node to be deleted and remove it
//        if (root == null)
//            return root;
//        if (value < root.value)
//            root.left = deleteNode(root.left, value);
//        else if (value > root.value)
//            root.right = deleteNode(root.right, value);
//        else {
//            if ((root.left == null) || (root.right == null)) {
//                Node temp = null;
//                if (temp == root.left)
//                    temp = root.right;
//                else
//                    temp = root.left;
//                if (temp == null) {
//                    temp = root;
//                    root = null;
//                } else
//                    root = temp;
//            } else {
//                Node temp = nodeWithMimumValue(root.right);
//                root.value = temp.value;
//                root.right = deleteNode(root.right, temp.value);
//            }
//        }
//        if (root == null)
//            return root;
//
//        // Update the balance factor of each node and balance the tree
//        root.height = max(height(root.left), height(root.right)) + 1;
//        int balanceFactor = getBalanceFactor(root);
//        if (balanceFactor > 1) {
//            if (getBalanceFactor(root.left) >= 0) {
//                return rightRotate(root);
//            } else {
//                root.left = leftRotate(root.left);
//                return rightRotate(root);
//            }
//        }
//        if (balanceFactor < -1) {
//            if (getBalanceFactor(root.right) <= 0) {
//                return leftRotate(root);
//            } else {
//                root.right = rightRotate(root.right);
//                return leftRotate(root);
//            }
//        }
//        return root;
//    }

}
