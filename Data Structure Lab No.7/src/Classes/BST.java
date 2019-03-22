package Classes;
import Classes.*;

//I extracted the information from the class book
public class BST<E extends Comparable<E>> {
    private Association<E, E> Node;
    private BST<E> leftNode, rightNode;
    private Node root; // this field refers to the root node of the Binary Search Tree

    // this is the constructor for the Binary Search Tree class
    public BST() {
        this.root = null;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
    public Node getRoot() { return this.root; }

    // this method does the inorder tree walk on the binary search tree
    public void inOrderTree(Node node) {
        if(node == null) {
            return;
        }
        inOrderTree(node.getLeftChild());
        System.out.print(node.getKey() + " ");
        inOrderTree(node.getRightChild());
    }

    // this method does the pre-order tree walk on the binary search tree
    public void preOrderTree(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.getKey() + " ");
        preOrderTree(node.getLeftChild());
        preOrderTree(node.getRightChild());
    }

    // this method does the post-order tree walk on the binary search tree
    public void postOrderTree(Node node) {
        if(node == null) {
            return;
        }
        postOrderTree(node.getLeftChild());
        postOrderTree(node.getRightChild());
        System.out.print(node.getKey() + " ");
    }

    /* this method finds the node with the minimum key value in the Binary Search Tree
    public Node findMinimum() {
        Node temp = this.root;
        while(temp.getLeftChild() != null) {
            temp = temp.getLeftChild();
        }
        return temp;
    }

    // this method finds the node with the maximum key value in the Binary Search Tree
    public Node findMaximum() {
        Node temp = this.root;
        while (temp.getRightChild() != null) {
            temp = temp.getRightChild();
        }
        return temp;
    }
    */

    // this method is used to search the Binary Search Tree for a node with the value passed in the parameter
    public Node searchNode(String key) {
        Node temp = this.root;
        while(temp != null && !temp.getKey().equals(key)) {
            if(key.compareTo(temp.getKey()) <= 0) {
                temp = temp.getLeftChild();
            } else {
                temp = temp.getRightChild();
            }
        }
        return temp;
    }
    /*
    public void insert(){
        if(this.Node.compareTo(key) < 0){
            if(leftNode != null){
                leftNode.insert(key, value);
            }
        }
        else if(this.Node.compareTo(key) < 0){
            if(rightNode != null){
                rightNode.insert(key, value);
            }
        }

    }
    */

    // this method inserts a node with a given key and equal for the value in the Binary Search Tree
    public void insertNode(String key, String value) {
        // allocate a new node object for the key that needs to be inserted in the Binary Search Tree
        Node node = new Node();
        node.setKey(value);
        node.setValue(key);
        node.setParent(null);
        node.setLeftChild(null);
        node.setRightChild(null);

        // if the Binary Search Tree is initially empty then we make the new node to be the root of the Binary Search Tree
        if(this.root == null) {
            this.root = node;
        } else {
            Node parentNode = null;
            Node temp = this.root;
            while(temp != null) {
                parentNode = temp;
                int compareValue = node.getKey().compareTo(temp.getKey());
                if(compareValue <= 0) {
                    temp = temp.getLeftChild();
                } else {
                    temp = temp.getRightChild();
                }
            }

            // set the new node's parent to be the parentNode object that was set in the loop
            node.setParent(parentNode);
            if(node.getKey().compareTo(parentNode.getKey()) <= 0) {
                parentNode.setLeftChild(node);
            } else {
                parentNode.setRightChild(node);
            }
        }
    }
}
