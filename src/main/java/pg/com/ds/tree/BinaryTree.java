package pg.com.ds.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTree {
	Node root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(int key) {
		root = new Node(key);
	}

	public void printLevelOrder() {
		if (root == null) {
			System.out.println("Tree is empty");
		} else {
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				for(int i = 0; i < size; i++) {
					Node temp = queue.poll();
					System.out.print(" " + temp.key);
					if (temp.left != null) {
						queue.add(temp.left);
					}

					if (temp.right != null) {
						queue.add(temp.right);
					}
				}
				
				System.out.println();
			}
		}
	}

	public void printTree() {
		if (root != null) {
			printTree(root);
		}
	}

	private void printTree(Node root) {
		System.out.print(" " + root.key);

		if (root.left != null) 
			printTree(root.left);
		
		if (root.right != null) 
			printTree(root.right);
	}
	
	public void inorderTraversal() {
		Stack<Node> s = new Stack<>();
		Node current = this.root;
		
		while(current != null || s.size() > 0) {
			
			while(current != null) {
				s.push(current);
				current = current.left;
			}
			
			Node temp = s.pop();
			System.out.print(" " + temp.key);
			
			current = temp.right; 
		}
	}
	
	public void preOrderTraversal() {
		if(this.root == null)
			return;
		Stack<Node> nodeStack = new Stack<>();
		nodeStack.push(this.root);
		
		while(nodeStack.isEmpty() == false) {
			Node temp = nodeStack.pop();
			System.out.print(" " + temp.key);
			
			if(temp.right != null)
				nodeStack.push(temp.right);
			
			if(temp.left != null) 
			    nodeStack.push(temp.left);	
		}
	}
	
	public void inorderTraversalRec() {
		inorderTraversal(this.root);
	}

	private void inorderTraversal(Node root) {
		if(root == null)
			return;
		
		inorderTraversal(root.left);
		System.out.print(" " + root.key);
		inorderTraversal(root.right);
	}
	
	public void leftView() {
		if(root == null) {
			System.out.println("Tree is empty");
		}
		
		Queue<Node> queue =new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 1; i <= size; i++) {
				Node temp = queue.poll();
				if(i == 1) {
					System.out.print(" " + temp.key);
				}
				if(temp.left != null)
					queue.add(temp.left);
				
				if(temp.right != null)
					queue.add(temp.right);
			}
		}
		
	}
	
	public void rightView() {
		if(root == null) {
			System.out.println("Tree is empty");
		}
		
		Queue<Node> queue =new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 1; i <= size; i++) {
				Node temp = queue.poll();
				if(i == size) {
					System.out.print(" " + temp.key);
				}
				if(temp.left != null)
					queue.add(temp.left);
				
				if(temp.right != null)
					queue.add(temp.right);
			}
		}
		
	}
	
	public void boundaryView() {
		if(root == null) {
			System.out.println("Tree is empty");
		}
		
		Queue<Node> queue =new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 1; i <= size; i++) {
				Node temp = queue.poll();
				if(i == size || i == 1) {
					System.out.print(" " + temp.key);
				}
				if(temp.left != null)
					queue.add(temp.left);
				
				if(temp.right != null)
					queue.add(temp.right);
			}
			System.out.println();
		}
		
	}
	
	public void bottomView() {
		if(root == null) {
			System.out.println("Tree is empty");
		}
		
		Queue<Node> queue =new LinkedList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		int hd = 0;
		Node rootNode = root;
		rootNode.hd = hd;
		queue.add(root);
		while(!queue.isEmpty()) {
				Node temp = queue.poll();
				
				hd = temp.hd;
				map.put(hd, temp.key);
				
				if(temp.left != null) {
					temp.left.hd = hd-1;
					queue.add(temp.left);
				}	
				
				if(temp.right != null) {
					temp.right.hd = hd+1;
					queue.add(temp.right);
				}
		}
		map.entrySet().forEach(s -> System.out.print(" " + s.getValue()));
		System.out.println();
	}
	
	public int getHeight(Node root) {
		if(root == null)
			return 0;
		
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public int getDiameter() {
		AtomicInteger res = new AtomicInteger(0);
		getDiameterOfTree(this.root, res);
		return res.get();
	}

	private int getDiameterOfTree(Node root, AtomicInteger res) {
		if(root == null)
			return 0;
		
		int l = getDiameterOfTree(root.left, res);
		int r = getDiameterOfTree(root.right, res);
		
		int temp = 1+Math.max(l, r);
		
		int ans  = Math.max(temp, 1+l+r);
		
		res.set(Math.max(temp, ans));
		
		return temp;
	}
	
	public void mirrorOfBTree() {
		mirrorOfBTree(this.root);
	}

	private Node mirrorOfBTree(Node root) {
		if(root == null)
			return root;
		
		Node left = mirrorOfBTree(root.left);
		Node right = mirrorOfBTree(root.right);
		
		root.left = right;
		root.right = left;
		
		return root;
	}
	
	public void zigzag() {
		if(this.root == null) {
			return;
		}
		
		Node root = this.root;
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.add(root);
		while(!stack1.isEmpty()) {
			while(!stack1.isEmpty()) {
				Node temp = stack1.pop();
				System.out.print(" " + temp.key);
				
				if(temp.left != null)
					stack2.add(temp.left);
				
				if(temp.right != null)
					stack2.add(temp.right);
			}
			
			
			while(!stack2.isEmpty()) {
				Node temp = stack2.pop();
				System.out.print(" " + temp.key);
				
				if(temp.right != null)
					stack1.add(temp.right);
				
				if(temp.left != null)
					stack1.add(temp.left);
			}
		}
		
	}
	
	public Node inorderSuccessor(Node root, Node n) {
		if(root == null) return root;
		
		if(n.right != null) {
			return minValueNode(n.right);
		}
		
		Node succ = null;
		while(root != null) {
			if(n.key< root.key) {
				succ = root;
				root = root.left;
			}else if(n.key > root.key) {
				root = root.right;
			}else {
				break;
			}
		}
		
		return succ;
	}

	private Node minValueNode(Node right) {
		Node curr = right;
		while(curr.left != null)
			curr = curr.left;
		return curr;
	}
	
	public void verticalOrderTraversal() {
		
	}
}
