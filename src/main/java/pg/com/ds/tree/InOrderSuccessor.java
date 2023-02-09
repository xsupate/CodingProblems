package pg.com.ds.tree;

public class InOrderSuccessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode inorderSuccessor(TreeNode root, TreeNode n) {
		if(root == null) return root;
		
		if(n.right != null) {
			return minValueNode(n.right);
		}
		
		TreeNode succ = null;
		while(root != null) {
			if(n.val < root.val) {
				succ = root;
				root = root.left;
			}else if(n.val > root.val) {
				root = root.right;
			}else {
				break;
			}
		}
		
		return succ;
	}

	private TreeNode minValueNode(TreeNode right) {
		TreeNode curr = right;
		while(curr.left != null)
			curr = curr.left;
		return curr;
	}
}
