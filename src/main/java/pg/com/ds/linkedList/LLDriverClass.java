package pg.com.ds.linkedList;

public class LLDriverClass {
	public static void main(String[] args) {
       LinkedListImpl linkedList = new LinkedListImpl();
       linkedList.head = new Node(3);
       linkedList.addNodeAtLast(5);
       linkedList.addNodeAtLast(10);
       linkedList.addNodeAtLast(2);
       linkedList.addNodeAtLast(8);
       linkedList.addNodeAtLast(2);
       linkedList.addNodeAtLast(1);
       
       LinkedListImpl linkedList1 = new LinkedListImpl();
       linkedList1.head = new Node(2);
       linkedList1.addNodeAtLast(3);
       linkedList1.addNodeAtLast(4);
       linkedList1.addNodeAtLast(9);
      
       //linkedList.head = linkedList.intersectionOfLL(linkedList.head, linkedList1.head);
       linkedList.head = LinkedListImpl.partition(linkedList.head, 5);
       linkedList.printAllNodes();
       
	}
}
