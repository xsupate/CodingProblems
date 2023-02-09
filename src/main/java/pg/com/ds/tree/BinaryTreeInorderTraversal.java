package pg.com.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return inorderTraversal(root, result);
    }
    
    private List<Integer> inorderTraversal(TreeNode root, List<Integer> result){
        if(root == null){
            return new ArrayList<>(result);
        }
        
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
        return result;
    }
}
