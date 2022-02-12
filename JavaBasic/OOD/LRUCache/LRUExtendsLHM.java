package JavaBasic.OOD.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUExtendsLHM extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUExtendsLHM(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    // this is very very interesting
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
