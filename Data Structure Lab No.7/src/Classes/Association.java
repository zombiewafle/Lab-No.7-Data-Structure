package Classes;

public class Association<K, V>{

    private K Key;
    private V Value;


    public Association(K key, V value){
        Key = key;
        Value = value;
    }

    public K getKey(){
        return Key;
    }

    public K setKey(K key){
        return key;
    }

    public V getValue(){
        return Value;
    }

    public V setValue(V value){
        return value;
    }
    //-----------------------------------------------------------------------------------------------------
    //Implementing compareTo (Comparable <T>) for a Binary Tree (Generic), (2014). Extracted from: https://stackoverflow.com/questions/27870652/implementing-compareto-comparablet-for-a-binary-treegeneric

    //Duane A. Bailey, (2006). Java Structures, Williamstown, MA, Williams College.
    //-----------------------------------------------------------------------------------------------------

    public int compareTo(V value){
        return ((String) value).compareTo((String) Value);
    }
}