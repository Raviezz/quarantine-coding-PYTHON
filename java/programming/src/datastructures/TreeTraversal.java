package datastructures;

import java.util.Stack;

public class TreeTraversal {
	
	public static void main(String[] args) {
		Node root = null;	
		root = BinarySearchTree.insert(root, 12);
		root = BinarySearchTree.insert(root, 10);
		root = BinarySearchTree.insert(root, 20);
		root = BinarySearchTree.insert(root, 9);
		root = BinarySearchTree.insert(root, 11);
		root = BinarySearchTree.insert(root, 10);
		root = BinarySearchTree.insert(root, 12);
		root = BinarySearchTree.insert(root, 12);
		System.out.print("postOrderLoop mate.................");
		postOrderLoop(root);
	}
	
	public static void inorder(Node root) { // Using recursion
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.value+"("+root.count+")");
		inorder(root.right);
	}
	
	public static void preOrder(Node root) { // Using recursion
		if(root == null) return;
		System.out.print(root.value+"("+root.count+")");
		preOrder(root.left);	
		preOrder(root.right);
	}
	public static void postOrder(Node root) { // Using recursion
		if(root == null) return;
		postOrder(root.left);	
		postOrder(root.right);
		System.out.print(root.value+"("+root.count+")");
	}
	
	public static void inOrderLoop(Node root) {
		Stack<Node> stack = new Stack<>();
		Node current  = root;
		while(current!=null || stack.size()!=0) {
			
			while(current!=null) {
				stack.push(current);
				current = current.left;
			}// when you come out of this loop, current may actually NULL
			
			current  = stack.pop(); // removes top Node and returns it, We get the last left node at first iteration
			System.out.print(current.value+"("+current.count+") "); // In Inorder first left, root, right
			// we already added root, left , now lets move to right;
			
			/*
			 *        2
			 *       / \
			 *      1   3
			 *      we added 2 and reached to 1 with inner loop , popped 1 , goes back to while, 
			 *      we told cur = cur.rigth which was 1's right , but its null; so no inner loop exec
			 *      cur = cur.pop gives 2's value node to cur , we print and pass cur = cur.right ie, 3
			 *      Hope you got it.
			 *         
			 */
			current = current.right;
		}
	}
	
	public static void preOrderLoop(Node root) {
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		/*
		 *       2
		 *      /  \
		 *     1     3
		 *     in preorder we visit parent , left , root 
		 *     initially add root to stack
		 *     pop it and print then add right child first and then left , so that left child gets first as it is at top of stack
		 *     
		 *     stack > 2
		 *     loop:
		 *     	  1.pop(2) > stack empty
		 *     		push(right) > stack |3|
		 *     
		 *     		push(left)  > stack |1|
		 *     							|3|
		 *     	   2.stack!empty
		 *           stack.pop(1) > stack |3|
		 *           push(right)  > null
		 *           push(left)   > null
		 *           	
 		 *         3. stack!empty
 		 *        	 stack.pop(3) > stack |empty|
		 *           push(right)  > null
		 *           push(left)   > null
		 *           
		 *        loop ends   
 		 *         
 		 *         
 		 *         
		 */
		while(!stack.isEmpty()) {
			Node temp = stack.pop();
			System.out.print(temp.value+"("+temp.count+")");
			if(temp.right!=null) stack.push(temp.right);
			if(temp.left!=null) stack.push(temp.left);
			
		}
	}
	
	public static void postOrderLoop(Node root) {
		
		/*
		 *  Here we need two stacks 
		 *  				5
		 *  			   /  \	
		 *  			  3    6
		 *               / \     
		 *              2   4
		 *             /
		 *            1  
		 *                       
		 *            
		 */					
		
		
		Stack<Node> s1,s2;
		 s1 = new Stack<>(); 
	        s2 = new Stack<>(); 
	  
	        if (root == null) 
	            return; 
	  /*
	   * 	s1						s2
	   *    |5|						|empty|
	   * pop & add left/right
	   *     |6|
	   *     |3|					|5|
	   *     
	   *     |3|					|6|
	   *   6 has no left right 		|5|
	   *   
	   *   	|4|						|3|
	   *    |2| 					|6|
	   *    						|5|
	   *    
	   *    |2| 4 has no L/R        |4|
	   *    						|3|
	   *    						|6|
	   * 							|5|
	   *						
	   *   |1|						|2|
	   *    						|4|
	   *    						|3|
	   * 							|6|
	   * 							|5|
	   *
	   *							|1|
	   *							|2|
	   * ||    						|4|
	   *    						|3|
	   * 							|6|
	   * 							|5|		
	   * 
	   */
	        s1.push(root); 
	        while (!s1.isEmpty()) { 				
	            Node temp = s1.pop();   			
	            s2.push(temp); 
	            if (temp.left != null) 
	                s1.push(temp.left); 
	            if (temp.right != null) 
	                s1.push(temp.right); 
	        } 
	        while (!s2.isEmpty()) { 
	            Node temp = s2.pop(); 
	            System.out.print(temp.value+"("+temp.count+")"); 
	        } 
	}

}
