package JavaBasic.OOD;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

//First try didn't work :( 
//LC 146 https://leetcode.com/problems/lru-cache/
public class LRUCache2 {
    // Queue + hashMap;
    private int capacity;
    private Map<Integer, Integer> map;
    private LinkedList<Integer> queue;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            queue.addFirst(key); // remove last ?
            return map.get(key);
        } else {
            return -1;
        }
    }

    // O(1)
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (queue.size() < capacity) {
                map.put(key, value);
                queue.addFirst(key);
            } else {
                // remove last
                int lastUsed = queue.removeLast();
                map.remove(lastUsed);
                // add new
                queue.addFirst(key);
                map.put(key, value);
            }
        } else {
            map.put(key, value);
            queue.addFirst(key); // do we need worry about remove it from the list ?? TODO
        }
    }

    public static void main(String[] args) {
        // first play with LinkedHashMap
        LinkedHashMap<Integer, String> lhMap = new LinkedHashMap<>();

    }
}
