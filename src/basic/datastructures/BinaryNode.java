package basic.datastructures;

public class BinaryNode {

    public Object value;
    public BinaryNode rightChild;
    public BinaryNode leftChild;
    public BinaryNode parent;

    public BinaryNode(Object value) {
        this.value = value;
    }
    
    public BinaryNode(long value) {
    	this.value = value;
    }
}
