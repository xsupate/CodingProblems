package pg.com.ds.linkedList;

import java.util.HashMap;

public class LRUCache {
	private HashMap<Integer, CacheNode> map;
	private int capacity, count;
	private CacheNode head, tail;

	public static void main(String[] args) {
		System.out.println("Going to test the LRU " + " Cache Implementation");
		LRUCache cache = new LRUCache(2);

		// it will store a key (1) with value 10 in the cache.
		cache.put(1, 10);

		// it will store a key (1) with value 10 in the cache.
		cache.put(2, 20);
		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10

		// evicts key 2 and store a key (3) with value 30 in the cache.
		cache.put(3, 30);

		System.out.println("Value for the key: 2 is " + cache.get(2)); // returns -1 (not found)

		// evicts key 1 and store a key (4) with value 40 in the cache.
		cache.put(4, 40);
		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns -1 (not found)
		System.out.println("Value for the key: 3 is " + cache.get(3)); // returns 30
		System.out.println("Value for the key: 4 is " + cache.get(4)); // return 40
	}

	public LRUCache(int capacity) {
		map = new HashMap<>();
		this.capacity = capacity;
		head = new CacheNode(0, 0);
		tail = new CacheNode(0, 0);
		head.next = tail;
		tail.pre = head;
		head.pre = null;
		tail.next = null;
	}

	private void addToHead(CacheNode node) {
		head.next.pre = node;
		node.next = head.next;
		node.pre = head;
		head.next = node;
	}

	private void deleteNode(CacheNode node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	public int get(int key) {
		if(map.get(key) != null) {
		   CacheNode node = map.get(key);
		   deleteNode(node);
		   addToHead(node);
		   return node.val;
		}else {
			return -1;
		}
		
	}

	public void put(int key, int value) {
		if (map.get(key) != null) {
			CacheNode temp = map.get(key);
			temp.val = value;
			deleteNode(temp);
			addToHead(temp);
		} else {
			CacheNode node = new CacheNode(key, value);
			map.put(key, node);
			if (count < capacity) {
				count++;
				addToHead(node);
			} else {
				map.remove(tail.pre.key);
				deleteNode(tail.pre);
				addToHead(node);
			}
		}
	}

	class CacheNode {
		int key;
		int val;

		CacheNode next;
		CacheNode pre;

		public CacheNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}
