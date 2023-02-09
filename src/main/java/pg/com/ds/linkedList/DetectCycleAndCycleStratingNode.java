package pg.com.ds.linkedList;

public class DetectCycleAndCycleStratingNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean cycleExist = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycleExist = true;
                break;
            }
        }
        
        if(cycleExist == false){
            return null;
        }
        
        slow = head;
        if (slow != fast) {
            while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
            }
          /* since fast->next is the looping point */
          return fast.next; /* remove loop */
        }
        /* This case is added if fast and slow pointer meet at first position. */
         else {
            while(fast.next != slow) {
                    fast = fast.next;
            }
            return fast.next;
        }
    }
}
