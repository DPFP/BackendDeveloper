package JavaBasic.OOD.LRUCache;

import java.util.LinkedHashMap;

public class LRUCacheWihLinkedHashMap {
    private int cap;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCacheWihLinkedHashMap(int capacity) {
        this.cap = capacity;
        this.cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        } else {
            makeRecent(key);
            return cache.get(key);
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // update the value
            // makeRecent(key); or
            cache.remove(key);
        } else {
            if (cache.size() >= cap) {
                // grab the first element
                // TODO: here is the key part
                int oldest = cache.keySet().iterator().next();
                cache.remove(oldest);
            }
        }
        cache.put(key, value);
    }

    private void makeRecent(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
