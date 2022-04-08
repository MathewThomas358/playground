package basic.datastructures;

import java.util.*;

public class BinarySearchTree {

    private BinaryNode root;
    
    public BinarySearchTree(long value) {
        this.root = new BinaryNode(value);
        /**
         * Assuming that the root will have a 
         * parent with value 0.
         */
        this.root.parent = new BinaryNode(0);
    }
    
    public BinaryNode getRoot() {
    	return root;
    }

    public void insertNode(BinaryNode node) throws InvalidBinarySearchKeyTypeException {
    	
    	if(Long.TYPE.isInstance(node.value) || Integer.TYPE.isInstance(node.value)) {
    		throw new InvalidBinarySearchKeyTypeException();
    	}
    	
        BinaryNode currentNode = this.root;
        
        while(currentNode != null && (currentNode.leftChild != null || currentNode.rightChild != null)) {
            if((long) node.value > (long) currentNode.value && currentNode.rightChild != null) {
                currentNode = currentNode.rightChild;
            } else if((long) node.value <= (long) currentNode.value && currentNode.leftChild != null) {
                currentNode = currentNode.leftChild;
            } else {
            	break;
            }
        }

        if(currentNode != null) {
            if((long) node.value > (long) currentNode.value) {
                currentNode.rightChild = node;
            } else {
                currentNode.leftChild = node;
            }
            node.parent = currentNode;
        }
    }

    public void findNode(long value) {
        BinaryNode currentNode = root;
        int level = 0;
        while(currentNode != null) {
            if((long) currentNode.value == value) {
                System.out.println("Found key " + value + " at level : " + level);
                return;
            }

            if(value > (long)currentNode.value) {
                currentNode = currentNode.rightChild;
            } else {
                currentNode = currentNode.leftChild;
            }
            level++;
        } 
        System.out.println("Key not found");
    }
    
    public void inOrder(BinaryNode node) {
    	if(node != null) {
    		inOrder(node.leftChild);
    		System.out.print(node.value + " ");
    		inOrder(node.rightChild);
    	}
    }

    public void inOrder(BinaryNode node, int[] array, ReferenceInteger index) {
        if(node != null) {
    		inOrder(node.leftChild, array, index);
    		array[index.value++] = ((Number) node.value).intValue();
    		inOrder(node.rightChild, array, index);
    	}
    }

    public int[] inOrder(int length) {
        int[] result = new int[length];
        
        ReferenceInteger index = new ReferenceInteger(0);
        inOrder(this.root, result, index);

        return result;
    }
    
    public void postOrder(BinaryNode node) {
    	if(node != null) {
    		postOrder(node.leftChild);
    		postOrder(node.rightChild);
    		System.out.print(node.value + " ");
    	}
    }
    
    public void preOrder(BinaryNode node) {
    	if(node != null) {
    		System.out.print(node.value + " ");
    		preOrder(node.leftChild);
    		preOrder(node.rightChild);
    	}
    }

    /**
     * Used to get the height of a tree. Root will 
     * always be at a height of 0.
     * @param node, the node from which the height 
     * is to be measured.
     * @return height of the tree
     */
    public int findHeight(BinaryNode node) {
        if(node == null || (node.rightChild == null && node.leftChild == null)) {
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        if(node.leftChild != null) leftHeight = findHeight(node.leftChild);
        if(node.rightChild != null) rightHeight = findHeight(node.rightChild);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
    * This exception is thrown if the type of value stored in the
    * node is not of int or long type.  
    */
    public class InvalidBinarySearchKeyTypeException extends Exception {

		private static final long serialVersionUID = 0L;

		InvalidBinarySearchKeyTypeException() {
			System.err.println("Only int or long allowed for BSTs");
        }
    }
    
    public class ReferenceInteger {
    	
    	private int value;
    	
    	public ReferenceInteger(int value) {
    		this.value = value;
    	} 
    	
    	public int getValue() {
    		return value;
    	}
    }
    
    public static void main(String[] args) throws InvalidBinarySearchKeyTypeException {
		
        Random rand = new Random();
        BinarySearchTree bst = new BinarySearchTree(rand.nextInt(64));

        for(int i = 0; i < 16; i++) {
            bst.insertNode(new BinaryNode(rand.nextInt(64)));
        }
        bst.inOrder(bst.getRoot());
        System.out.println();
        bst.preOrder(bst.getRoot());
        System.out.println();
        bst.findNode(rand.nextInt(64));
        System.out.println("Height : " + bst.findHeight(bst.getRoot()));
	}
}
