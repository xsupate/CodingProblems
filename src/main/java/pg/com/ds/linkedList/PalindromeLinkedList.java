package pg.com.ds.linkedList;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		
		System.out.println("Is Palindrome Linked List : " + isPalindrome(head));
	}

	public static boolean isPalindrome(Node head) {
		Node slow = head;
		Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = reversed(slow);
        fast = head;
        
        while(slow != null){
            if(slow.key != fast.key){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        } 
        return true; 
    }
    
    private static Node reversed(Node head){
    	Node prev = null;
        while(head != null){
        	Node temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
