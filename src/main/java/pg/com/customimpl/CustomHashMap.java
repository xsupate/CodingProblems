package pg.com.customimpl;

import java.util.LinkedList;

class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private LinkedList<Entry<K, V>>[] table;
    private int size;

	public CustomHashMap() {
        this.table = new LinkedList[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Inner class to represent key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Helper method to compute the hash code for a key
    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    // Helper method to find an entry in the linked list based on key
    private Entry<K, V> findEntry(LinkedList<Entry<K, V>> bucket, K key) {
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry;
            }
        }
        return null;
    }

    // Method to put a key-value pair into the map
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        LinkedList<Entry<K, V>> bucket = table[index];
        Entry<K, V> existingEntry = findEntry(bucket, key);

        if (existingEntry != null) {
            // If the key already exists, update the value
            existingEntry.value = value;
        } else {
            // Add a new entry
            bucket.add(new Entry<>(key, value));
            size++;

            // Check if the load factor is exceeded, and if so, resize the table
            if ((double) size / table.length > LOAD_FACTOR) {
                resize();
            }
        }
    }

    // Method to get the value associated with a key
    public V get(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }

        Entry<K, V> entry = findEntry(table[index], key);
        return entry != null ? entry.value : null;
    }

    // Method to remove a key-value pair from the map
    public void remove(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return;
        }

        Entry<K, V> entryToRemove = findEntry(table[index], key);
        if (entryToRemove != null) {
            table[index].remove(entryToRemove);
            size--;
        }
    }

    // Helper method to resize the table when the load factor is exceeded
    private void resize() {
        LinkedList<Entry<K, V>>[] oldTable = table;
        table = new LinkedList[oldTable.length * 2];
        size = 0;

        for (LinkedList<Entry<K, V>> bucket : oldTable) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    put(entry.key, entry.value);
                }
            }
        }
    }

    // Method to get the size of the map
    public int size() {
        return size;
    }
}
