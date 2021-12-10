package binarySearchTree;

public class BST<T extends Comparable<T>>{

    private class Node {
        T data;
        Node left;
        Node right;

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int treeSize = 0; //number of nodes within the tree

    public int size() {
        return treeSize;
    }

    public boolean isEmpty() {
        return root == null;
    }

    //return true if node insertion was successful
    //return false if node already exists
    public boolean add(T data) {
        if(contains(data)) {
            return false;
        } else {
            root = add(root, data);
            treeSize++;
            return true;
        }
    }

    private Node add(Node node, T data) {
        if(node == null) {
            node = new Node(data, null, null);
        } else {
            if(data.compareTo(node.data) < 0) {
                node.left = add(node.left, data);
            } else {
                node.right = add(node.right, data);
            }
        }

        return node;
    }

    public boolean remove(T data) {
        if(contains(data)) {
            root = remove(root, data);
            treeSize--;
            return true;
        }

        return false;
    }

    private Node remove(Node node, T data) {
        if(node == null) {
            return null; //not found
        }

        int cmp = data.compareTo(node.data);

        if(cmp < 0) {
            node.left = remove(node.left, data);
        } else if(cmp > 0) {
            node.right = remove(node.right, data);
        } else {
            //we need to check how many children the node to remove has
            //if it only has 1 child on either side, just move up the subtree
            if(node.left == null) {
                Node rightChild = node.right;
                node.data = null;
                node = null;
                return rightChild;
            } else if(node.right == null) {
                Node leftChild = node.left;
                node.data = null;
                node = null;
                return leftChild;
            }
        }
    }
}
