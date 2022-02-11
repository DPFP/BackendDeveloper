public class CLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public CLinkedList(int data) {
        this.root = new Node(data);
    }

    int countNodes(Node head) {
        int counter = 1; // 1 with cur.next or 0 with cur
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
            counter++;
        }
        return counter;
    }

    void add(Node node) {
        if (this.root != null) {
            this.root.next = node;
        } else {
            this.root = node;
        }
    }
}
