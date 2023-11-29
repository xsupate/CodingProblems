package pg.com.customimpl;

import java.util.LinkedList;

public class CustomHashMap1<K,V> {
  private int DEFAULT_SIZE = 16;
  private double LOAD_FACTOR = 0.75;
  
  private LinkedList<Entry<K, V>>[] table;
  private int size;
  
  public CustomHashMap1() {
	  this.table = new LinkedList[DEFAULT_SIZE];
	  this.size = 0;
  }
  
  
  private static class Entry<K,V>{
	  K key;
	  V value;
	  
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	  
  }
  
  private int hash(K key) {
	  return key.hashCode() % table.length;
  }
  
  private Entry<K,V> findEntry(LinkedList<Entry<K,V>> list, K key){
	for(Entry<K,V> entry : list) {
		if(entry.key.equals(key))
			return entry;
	}
	  
	return null;
  }
  
  public void put(K key, V value) {
	int index = hash(key);
	if(table[index] == null) {
		table[index] = new LinkedList<>();
	}
	
	LinkedList<Entry<K,V>> bucket = table[index];
	
	Entry<K,V> existingEntry = findEntry(bucket, key);
	if(existingEntry == null) {
		bucket.add(new Entry<>(key, value));
		size ++;
		//TODO: resize if reached to load factor 
	}else {
		existingEntry.value = value;
	}
	  
  }
  
  public V get(K key) {
	  int index = hash(key);
	  LinkedList<Entry<K,V>> bucket = table[index];
	  
	  if(bucket == null)
		  return null;
	  
	  Entry<K,V> entry = findEntry(bucket, key);  
	  return entry == null ? null : entry.value; 
  }
  
}
