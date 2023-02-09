package pg.com.ds.tree;

public class SumEvenGrandParentNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sumEvenGrandparent(TreeNode root) {
		if(root == null) return 0;
		int a=0, b=0, c=0, d=0;
		if(root.val % 2 == 0) {
			if(root.left != null) {
				if(root.left.left != null) {
					a = root.left.left.val;
				}
				
				if(root.left.right != null) {
					b = root.left.right.val;
				}
			}
			
			if(root.right != null) {
				if(root.right.left != null) {
					c = root.right.left.val;
				}
				
				if(root.right.right != null) {
					d = root.right.right.val;
				}
			}
		}
		
		return a+b+c+d+sumEvenGrandparent(root.left)+sumEvenGrandparent(root.right);
	}
}
