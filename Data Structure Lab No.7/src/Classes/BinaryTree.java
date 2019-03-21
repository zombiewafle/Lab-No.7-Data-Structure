package Classes;
public class BinaryTree<E extends Comparable<E>>{

    private BinaryTree<E> leftNode, rightNode;
    private Association<E,E> Node;

    private BinaryTree root;

    //--------------------------------------------------------
    //The creation of a binary tree using generecis and association
    public BinaryTree(E key, E value){
        this.Node = new Association<E,E>(key,value);
    }
    //--------------------------------------------------------
    //Binary Search CompareTo Java, (2019). Extracted from: https://stackoverflow.com/questions/29356436/binary-search-compareto-java

    //Create code for Binary Search Tree using compareTo method using I/O, (2010). Extracted from: https://www.daniweb.com/programming/software-development/threads/229725/create-code-for-binary-search-tree-using-compareto-method-using-i-o

    //using compareTo in Binary Search Tree Program, (2019). Extracted from: https://stackoverflow.com/questions/8206432/using-compareto-in-binary-search-tree-program#
    //--------------------------------------------------------

    public E get(E key){
        if(Node.compareTo(key) == 0){
            return this.get(key);
        }

        if(this.Node.compareTo(key) < 0){
            return leftNode.get(key);
        }else{
            return rightNode.get(key);
        }
    }

    public void insert(E key, E value){
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
  /*
  public Node keySearch(Node root, String key){
    if(root == null || root.key == key){
      return root;
    }

    if(root.key > key){
      return search(root.left, key);
    }
    else{
      return search(root.right, key);
    }
  }

  public boolean searchValue(String value){
    if(root == null){
      return false;
    }
    else{
      return root.searchValue("*" + value + "*");
    }
  }

  public boolean searchKey(String key){
    if(root = null){
      return false;
    }
    else{
      return root.searchKey(key);
    }
  }
  */

    public String searchKeyReturnValue(String key){
        if(root == null){
            return "No key was found";
        }
        else{
            return root.searchKeyReturnValue(key);
        }
    }

    /*
    public boolean searchValueReturnKey(String key, String value){
        if(root == null){
            return false;
        }
        else{
            return root.searchValueReturnKey(key, value);
        }
    }
    */

    //Shows if the key that was inserted is alredy on the tree or not
    public Boolean onlyOneExistingKey(E key){
        return this.get(key) != null;
    }

    public Boolean isEmpty(){
        return root == null;
    }

    public void inOrderTree(E key , E value){
        if(!isEmpty()){
            root.leftNode.inOrderTree(key, value);
            root.rightNode.inOrderTree(key, value);
            System.out.println(this.Node.getKey() + " || " + this.Node.getValue());

        }
    }
}