package JavaBasic.OOD.LRUCache;

//Tutorial From Labuladong 
//https://labuladong.gitee.io/algo/2/20/45/
public class DoubleList {
    // pseudo head and pseudo tail to mark the boundary
    private Node head, tail;
    // linkedlist size
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // TODO pay more attention here
    // 在链表尾部添加节点 x，时间 O(1)
    public void addLast(Node x) {
        // insert between likedlist_tail
        x.prev = tail.prev;
        x.next = tail;

        // prev - x - tail
        tail.prev.next = x;
        tail.prev = x;

        size++;
    }
    // 注意我们实现的双链表 API 只能从尾部插入，也就是说靠尾部的数据是最近使用的，靠头部的数据是最久为使用的。

    // 删除链表中的 x 节点（x 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    // One advantage of double linked list is that the node can remove itself
    // without other reference. In addition, it takes constant time to add and
    // remove nodes from the head or tail.
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除链表中第一个节点，并返回该节点，时间 O(1)
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    public int size() {
        return size;
    }
}

class Node {
    public int key, val;
    public Node next, prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}
