package com.company;

public class MyTreeMap implements MyMap {

    private static class Node {
        private int key;
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(int key) {
        Node tmp = root;
        while (tmp != null) {
            if (key == tmp.key) {
                return true;
            }
            if (key < tmp.key) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(int value) {
        return false;
    }

    @Override
    public int get(int key) {
        Node tmp = root;
        while (tmp != null) {
            if (key == tmp.key) {
                return tmp.value;
            }
            if (key < tmp.key) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        return 0;
    }

    @Override
    public void put(int key, int value) {
        if (root == null) {
            root = new Node(key, value);
        } else {
            putInTree(root, key, value);
        }
        size++;
    }

    private void putInTree(Node node, int key, int value) {
        Node newNode = new Node(key, value);
        if (key > node.key) {
            if (node.right == null) {
                node.right = newNode;
                return;
            } else {
                putInTree(node.right, key, value);
            }
        }
        if (key < node.key) {
            if (node.left == null) {
                node.left = newNode;
                return;
            } else {
                putInTree(node.left, key, value);
            }
        }
    }

    @Override
    public void remove() {

    }

    @Override
    public int size() {
        return size;
    }
}
