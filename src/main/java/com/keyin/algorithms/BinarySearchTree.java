package com.keyin.algorithms;

public class BinarySearchTree {

    public Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        this.root = insert(root, value);
    }

    public Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        } else if (root.value >= value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void deleteANode(int value) {
        deleteNode(this.root, value);
    }

    public Node deleteNode(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (value < root.value) {
            root.left = deleteNode(root.left, value);
            return root;
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
            return root;
        } else {
            if (root.left == null && root.right == null){
                root = null;
                return root;
            }
            if (root.left == null) {
                root = root.right;
                return root;
            } else if (root.right == null) {
                root = root.left;
                return root;
            }
            int aux = this.findMinData(root.right);
            root.value = aux;
            root.right = this.deleteNode(root.right,aux);
            return root;
        }
    }

    public int findMaxData(Node root) {
        if (root.right != null) {
            return findMaxData(root.right);
        } else {
            return root.value;
        }
    }

    public int findMinData(Node root) {
        if (root.left != null) {
            return findMinData(root.left);
        } else {
            return root.value;
        }
    }

    public void preorder() {
        preorder(root);
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preorder(root.left);
        preorder(root.right);

    }

    public boolean search(int value) {
        return search(this.root, value);
    }

    private boolean search(Node root, int value) {
        if (root == null) {
            return false;
        } else if (root.value == value) {
            return true;
        } else if (root.value > value) {
            return search(root.left, value);
        }
        return search(root.right, value);
    }

}
