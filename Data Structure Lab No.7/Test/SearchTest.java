import Classes.Node;

public class SearchTest {

    private Node root; // this field refers to the root node of the Binary Search Tree


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
}
