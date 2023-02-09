package pg.com.ds.tree;

public class Node {
	int key;
	int hd;
	Node left, right;

	public Node(int data) {
		this.key = data;
		left = right = null;
	}
	
	public Node() {
	}
}
