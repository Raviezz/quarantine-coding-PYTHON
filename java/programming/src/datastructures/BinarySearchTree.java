package datastructures;
/**
 * 
 * @author Raviteja
 *
 * Simple Binary Search DS which handles with duplicates 
 *
 */
public class BinarySearchTree {
	
	static Node newNode(int item) {
		Node temp = new Node();
		temp.value = item;
		temp.left = temp.right = null;
		temp.count = 1;
		return temp;
	}

	static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.value + "(" + root.count + ") ");
			inorder(root.right);
		}
	}

	static Node insert(Node node, int value) {
		if (node == null)
			return newNode(value);
		if (value == node.value) {
			(node.count)++;
			return node;
		}
		if (value < node.value)
			node.left = insert(node.left, value);
		else
			node.right = insert(node.right, value);
		return node;
	}

	static Node minValueNode(Node node) {
		Node current = node;
		while (current.left != null)
			current = current.left;

		return current;
	}

	static Node deleteNode(Node root, int value) {

		if (root == null)
			return root;

		if (value < root.value)
			root.left = deleteNode(root.left, value);

		else if (value > root.value)
			root.right = deleteNode(root.right, value);

		else {

			if (root.count > 1) {
				(root.count)--;
				return root;
			}

			if (root.left == null) {
				Node temp = root.right;
				root = null;
				return temp;
			} else if (root.right == null) {
				Node temp = root.left;
				root = null;
				return temp;
			}

			Node temp = minValueNode(root.right);
			root.value = temp.value;
			root.right = deleteNode(root.right, temp.value);
		}
		return root;
	}

	public static void main(String[] args) {
		Node root = null;
		root = insert(root, 12);
		root = insert(root, 10);
		root = insert(root, 20);
		root = insert(root, 9);
		root = insert(root, 11);
		root = insert(root, 10);
		root = insert(root, 12);
		root = insert(root, 12);

		System.out.print("Inorder traversal \n");
		inorder(root);

		System.out.print("\nDelete 20\n");
		root = deleteNode(root, 20);
		System.out.print("Inorder traversal \n");
		inorder(root);

		System.out.print("\nDelete 12\n");
		root = deleteNode(root, 12);
		System.out.print("Inorder traversal \n");
		inorder(root);

		System.out.print("\nDelete 9\n");
		root = deleteNode(root, 9);
		System.out.print("Inorder traversal \n");
		inorder(root);
	}
}
