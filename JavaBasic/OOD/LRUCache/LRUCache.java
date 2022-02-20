package JavaBasic.OOD.LRUCache;

import java.util.HashMap;

public class LRUCache implements LRUCacheInterface {
    // added the interface, so we can swap different implementation if necessary in
    // the future;
    // https://www.baeldung.com/java-lru-cache

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap; // capacity

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    // 先不慌去实现 LRU 算法的 get 和 put 方法。由于我们要同时维护一个双链表 cache 和一个哈希表 map，很容易漏掉一些操作，比如说删除某个
    // key 时，在 cache 中删除了对应的 Node，但是却忘记在 map 中删除 key。
    // 解决方法是：在这两种数据结构之上提供一层抽象 API。 (就是不要让LRU 直接操作 map 和 cache)

    // abstract API methods
    private void makeRecently(int key) {
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    private void addRecently(int key, int value) {
        Node x = new Node(key, value);
        cache.addLast(x);
        map.put(key, x);
    }

    private void deleteKey(int key) {
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    // 这里就能回答之前的问答题「为什么要在链表中同时存储 key 和 val，而不是只存储 val」
    private void removeLeastRecently() {
        Node deletedNode = cache.removeFirst();
        int deletedKey = deletedNode.key; // need to remove from the map
        map.remove(deletedKey);
    }
    // 上述方法就是简单的操作封装，调用这些函数可以避免直接操作 cache 链表和 map 哈希表

    @Override
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    @Override
    public void put(int key, int val) {
        if (map.containsKey(key)) {
            // missing this step
            deleteKey(key); // remove the old one
        } else {
            // check capacity
            if (cache.size() == cap) {
                removeLeastRecently();
            }
        }
        // always make it most recently
        addRecently(key, val); // update
    }

    @Override
    public int size() {
        return this.cache.size();
    }

    // Try
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);

        System.out.println(cache.size());
        cache.put(4,4);

        System.out.println(cache.get(1));;
    }
}
