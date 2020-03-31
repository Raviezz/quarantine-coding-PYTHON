package datastructures;

public class Node {

	/**
	 * Might be used for other classes
	 */
	
	public int value;
	public int count;
	public Node left, right;
	public Node() {
		// TODO Auto-generated constructor stub
	}
	public Node(int value) {
		this.value = value;
		this.left = this.right = null;
	}

}