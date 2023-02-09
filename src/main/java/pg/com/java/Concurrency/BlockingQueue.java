package pg.com.java.Concurrency;

public class BlockingQueue <T> {
  T[] array;
  int size;
  int capacity;
  int tail; // for enqueue
  int head; // for dequeue
  
  @SuppressWarnings("unchecked")
  public BlockingQueue (int capacity){
	  array = (T[]) new Object[capacity];
	  this.capacity = capacity;
  }
  
  public synchronized void enqueue(T temp) {
	  while(size == capacity) {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  }
	  
	  if(tail == capacity) {
		  tail = 0;
	  }
	  
	  array[tail++] = temp;
	  size++;
	  notifyAll();
  }
  
  public synchronized T dequeue() {
	  T item = null;
	  while(size == 0) {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  }
	  
	  if(head == capacity) {
		  head = 0;
	  }
	  
	  item = array[head];
	  array[head] = null;
	  head++;
	  size--;
	  notifyAll();
	  return item;
  }
}
