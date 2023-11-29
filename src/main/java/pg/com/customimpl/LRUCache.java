package pg.com.customimpl;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 1L;
    private final int capacity;

    public LRUCache(int capacity) {
        // Setting accessOrder to true enables access order instead of insertion order
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // Remove the eldest entry when the size exceeds the specified capacity
        return size() > capacity;
    }

    public static void main(String[] args) {
        // Example usage of LRUCache
        LRUCache<String, Integer> lruCache = new LRUCache<>(3);

        lruCache.put("one", 1);
        lruCache.put("two", 2);
        lruCache.put("three", 3);

        System.out.println("LRU Cache: " + lruCache);

        lruCache.get("one"); // Accessing "one" to make it the most recently used

        lruCache.put("four", 4); // Adding a new entry, which should trigger eviction

        System.out.println("LRU Cache after eviction: " + lruCache);
        
        lruCache.get("three"); // Accessing "one" to make it the most recently used
        
        System.out.println("LRU Cache after eviction: " + lruCache);
    }
}

