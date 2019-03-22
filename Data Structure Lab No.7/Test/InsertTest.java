import Classes.Node;

public class InsertTest {
    private Node root; // this field refers to the root node of the Binary Search Tree

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
