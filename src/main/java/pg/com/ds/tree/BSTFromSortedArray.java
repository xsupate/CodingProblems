package pg.com.ds.tree;

public class BSTFromSortedArray {

	public static void main(String[] args) {
       int[] nums = {-10,-3,4,5,9};
       TreeNode root = sortedArrayToBST(nums);
       System.out.println("Root is "+ root.val);
	}
	
	public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        
        return contructBSTFromSortedArray(nums, 0, nums.length-1);
    }
    
    private static TreeNode contructBSTFromSortedArray(int[] nums, int left, int right){
        if(left > right) 
            return null;
        
        int midPoint = left + (right-left)/2;
        TreeNode node = new TreeNode(nums[midPoint]);
        node.left = contructBSTFromSortedArray(nums, left, midPoint-1);
        node.right = contructBSTFromSortedArray(nums,midPoint+1, right);
        
        return node;
    }

//  Definition for a binary tree node.
 static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
}



 