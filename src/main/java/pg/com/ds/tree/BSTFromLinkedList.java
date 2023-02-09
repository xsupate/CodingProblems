package pg.com.ds.tree;

import pg.com.ds.tree.BSTFromSortedArray.TreeNode;

public class BSTFromLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        
        if(mid == head) 
            return root;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
    
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(prev != null)
            prev.next = null;
        
        return slow;
    } 
}

/**
 * Definition for singly-linked list.
 */
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 