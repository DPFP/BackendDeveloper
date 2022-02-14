package JavaBasic.OOD.LRUCache;

public interface LRUCacheInterface {
    int get(int key);

    void put(int key, int val);

    int size();
}
