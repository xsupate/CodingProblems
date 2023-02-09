package pg.com.ds.linkedList;

class ListNode {
	int val;
	ListNode next;

	ListNode() {}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class AddTwoNumberList {
	public ListNode addTwoNumbers(ListNode first, ListNode second) {
		ListNode res = null;
		ListNode prev = null;
		ListNode temp = null;
        int carry = 0, sum;
 
        // while both lists exist
        while (first != null || second != null) {
            sum = carry + (first != null ? first.val : 0) + (second != null ? second.val : 0);
 
            // update carry for next calculation
            carry = sum/10;
 
            // Create a new node with sum as data
            temp = new ListNode(sum % 10);
 
            // if this is the first node then set it as head of the resultant list
            if (res == null) {
                res = temp;
            }// If this is not the first node then connect it to the rest.
            else {
                prev.next = temp;
            }
 
            // Set prev for next insertion
            prev = temp;
 
            // Move first and second pointers to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }
 
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
 
        return res;
	}
}
