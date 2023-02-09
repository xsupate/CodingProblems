package pg.com.ds.tree;

public class ValidateBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValidBST(TreeNode root) {
		return isTrue(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	boolean isTrue(TreeNode root, long min, long max) {
		if (root == null)
			return true;

		if (root.val > min && root.val < max) {
			return isTrue(root.left, min, root.val) && isTrue(root.right, root.val, max);
		}
		return false;
	}
}

/**
 * Definition for a binary tree node.
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
 