package basic.datastructures;

class BinaryTree {

	private BinaryNode root;
	
	public BinaryNode getRoot() {
		return root;
	}

	public BinaryTree() {
		this.root = new BinaryNode(null);
	}
}