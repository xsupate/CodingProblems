package pg.com.ds.linkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListImpl {
	protected Node head;

	public LinkedListImpl() {
		head = null;
	}

	public void addNodeAtLast(int data) {
		Node newNode = new Node(data);
		if (this.head == null) {
			this.head = newNode;
		} else {
			Node temp = this.head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public void printAllNodes() {
		if (this.head == null) {
			System.out.println("The list is empty");
		}
		Node temp = this.head;
		while (temp != null) {
			System.out.print(" " + temp.key);
			temp = temp.next;
		}
	}

	public Node reverseIter(Node head) {
		Node prev = null;
		Node curr = head;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}

	public Node reverse() {
		if (this.head == null) {
			System.out.println("The linked list is empty");
			return null;
		} else {
			this.head = reverse(this.head, null);
			return head;
		}
	}

	private Node reverse(Node curr, Node prev) {
		if (curr.next == null) {
			curr.next = prev;
			return curr;
		}
		Node next = curr.next;
		curr.next = prev;
		return reverse(next, curr);
	}
	
	public void revrseInGroup(int k) {
		reverseInGroup(k, null);
	}

	//TODO need to complete this method
	private void reverseInGroup(int k, Node nextNode) {
		Node prev = null;
		Node curr = this.head;
		Node next = null;
		int count = 1;
		Node oldStart = this.head;
		while(count != k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
	}
	
	// Remove duplicate from sorted list
	public void removeDuplicates() {
		Node curr = this.head;
		while(curr != null) {
			Node temp = curr.next;
			while(temp != null && temp.key == curr.key) {
				temp = temp.next;
			}
			curr.next = temp;
			curr = curr.next;
		}
	}
	
	public void removeDuplicatesFromUnsorted() {
		Set<Integer> keys = new HashSet<>();
		Node curr = this.head;
		Node next = curr.next;
		while(next != null) {
			if(!keys.contains(next.key)) {
				keys.add(next.key);
				curr.next = next;
				curr = next;
			}
			next = next.next;
		}
		curr.next = null;
	}
	
	public void moveLastToStart() {
		Node prev = null;
		Node curr = this.head;
		while(curr.next != null) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = null;
		curr.next = this.head;
		this.head = curr;
	}
	
	public Node mergeSort(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node midNode = getMiddleNode(head);
		Node nextToMidNode = midNode.next;
		midNode.next = null;
		
		Node left = mergeSort(head);
		Node right = mergeSort(nextToMidNode);
		return mergeSortedList(left, right);
	}

	private Node mergeSortedList(Node left, Node right) {
		Node result = null;
		
		if(left == null) {
			return right;
		}
		
		if(right == null) {
			return left;
		}
		
		if(left.key <= right.key) {
			result = left;
			result.next = mergeSortedList(left.next, right);
		}else {
			result = right;
			result.next = mergeSortedList(left, right.next);
		}
		
		return result;
	}

	private Node getMiddleNode(Node head) {
		Node slow = head, fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public Node addOne(Node head) {
		Node reverse = reverse();

		addOneUtil(reverse);
		
		return reverse();
	}

	private void addOneUtil(Node head) {
		Node prev = null;
		int sum,carry=1;
		
		while(head != null) {
			sum = head.key + carry;
			carry = sum >= 10 ? 1:0;
			sum = sum%10;
			head.key = sum;
			prev = head;
			head= head.next;
		}
		
		if(carry > 0) {
			prev.next = new Node(carry);
		}
	}
	
	/**
	 * This is recursive approach to add 1 to the given linked list
	 * @param head
	 * @return
	 */
	public Node addOneRecu(Node head) {
		int carry = addWithCarry(head);
		
		if(carry > 0) {
			Node newNode = new Node(carry);
			newNode.next = head;
           return newNode;
		}
		return head;
	}

	private int addWithCarry(Node head) {
		if(head == null)
			return 1;
		
		int res = head.key + addWithCarry(head.next);
		
		head.key = res %10;
		
		return res/10;
	}
	 
	public Node addTwoLinkedList(Node l1, Node l2) {
		l1 = reverseIter(l1);
		l2 = reverseIter(l2);
		return addLinkedList(l1,l2);
	}

	private Node addLinkedList(Node l1, Node l2) {
		if(l1 == null)
			return l2;
		
		if(l2 == null)
			return l1;
		
		Node prev = null, head = l1;
		int carry = 0, sum;
		while(l1 != null & l2 != null) {
			sum = carry+l1.key + l2.key;
			l1.key = sum %10;
			carry = sum / 10;
			prev = l1;
			l1 = l1.next;
			l2 = l2.next;
		}
		
		if(l1 != null || l2 != null) {
			if(l1 == null) {
				prev.next = l2;
				l1 = prev.next;
			}
			while(l1 != null) {
				sum = carry+l1.key;
				l1.key = sum %10;
				carry = sum / 10;
				prev = l1;
				l1 = l1.next;
			}
		}
		
		if(carry > 0) {
			prev.next = new Node(carry);
			l1 = prev.next;
		}
		
		return reverseIter(head);
	}
	
	public Node intersectionOfLL(Node l1, Node l2) {
		Node tail = null;
		Node head = null;
		while(l1 != null && l2 != null) {
			if(l1.key < l2.key) {
				l1 = l1.next;
			}else if(l1.key > l2.key) {
				l2 = l2.next;
			}else {
				Node temp = new Node(l1.key);
				if(head == null) {
					head = temp;
					tail = temp;
				}else {
					tail.next = temp;
					tail = temp;
				}
				l1 = l1.next;
				l2 = l2.next;
			}
		}
		
		return head;
	}
	
	static Node partition(Node head, int x){ 
		Node curr = head;
		Node tail = head;
		while(curr != null) {
			Node next = curr.next;
			if(curr.key < x) {
				curr.next = head;
				head = curr;
			}else {
				tail.next = curr;
				tail = curr;
			}
			curr = next;
		}
		
		tail.next = null;
		return head;
	}
	
	static Node partitionWithSameOrder(Node head, int x){ 
		/* Let us initialize first and last nodes of three linked lists 
	        1) Linked list of values smaller than x. 
	        2) Linked list of values equal to x. 
	        3) Linked list of values greater than x.*/
	    Node smallerHead = null, smallerLast = null; 
	    Node greaterLast = null, greaterHead = null; 
	    Node equalHead = null, equalLast =null;
		while(head != null) {
			if(head.key == x) {
				if(equalHead == null) {
					equalHead = equalLast= head;
				}else {
					equalLast.next = head;
					equalLast = head;
				}
			}
			
			if(head.key < x) {
				if(smallerHead == null) {
					smallerHead = smallerLast= head;
				}else {
					smallerLast.next = head;
					smallerLast = head;
				}
			}
			
			if(head.key > x) {
				if(greaterHead == null) {
					greaterHead = greaterLast= head;
				}else {
					greaterLast.next = head;
					greaterLast = head;
				}
			}
			head = head.next;
		}
		
		if(greaterLast != null) {
			greaterLast.next = null;
		}
		
		if(smallerHead == null) {
			if(equalHead == null)
				return greaterLast;
			else 
				equalLast.next = greaterHead;
			return equalHead;
		}
		
		// if equal list is empty and smaller list is not empty
		if(equalHead == null) {
			smallerLast.next = greaterHead;
			return smallerHead;
		}
		
		// If both smaller and equal list are non-empty 
		smallerLast.next = equalHead;
		equalLast.next = greaterHead;
		
		return smallerHead;
	}
}
