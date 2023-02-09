package pg.com.ds.tree;

public class BinaryTreeImpl {

	public static void main(String[] args) {
       BinaryTree bTree = new BinaryTree(50);
       bTree.root.left = new Node(25);
       bTree.root.left.left = new Node(15);
       bTree.root.left.right = new Node(30);
       
       bTree.root.right = new Node(75);
       Node node = new Node(55);
       bTree.root.right.left = node;
       bTree.root.right.right = new Node(80);
       bTree.root.right.right.right = new Node(89);
       
       bTree.inorderTraversal();
       System.out.println();
       System.out.println(" Inorder successor is " + bTree.inorderSuccessor(bTree.root, node).key);
       /*System.out.println();
       bTree.inorderTraversal();
       System.out.println();
       bTree.inorderTraversalRec();
       System.out.println();*/
       /*bTree.leftView();
       System.out.println();
       bTree.rightView();
       System.out.println();
       bTree.topView();
       System.out.println();
       bTree.bottomView();
       System.out.println("Height of bTree : " + bTree.getHeight(bTree.root));
       System.out.println();
       System.out.println("Diameter of bTree " + bTree.getDiameter());
       bTree.inorderTraversalRec();
       System.out.println();
       bTree.zigzag();*/
       
       
	}

}
