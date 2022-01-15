import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
    // 133 Clone Graph https://leetcode.com/problems/clone-graph/

    // initial try -- Stuck on connecting the nodes
    public Node cloneGraph(Node node) {
        if (node == null) {
            System.out.print("Nothing");
            return null;
        }

        // not necessary true (it could be two nodes)
        if (node.neighbors.size() == 1) {
            System.out.print("Only 1 neighbor");
            // return new Node(node.val);
        }

        Node newNode = new Node(node.val);

        // let's first try visit all of the nodes;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(node.val);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(" " + cur.val);
            List<Node> neighbors = new ArrayList<>();

            for (Node n : cur.neighbors) {
                neighbors.add(new Node(n.val));
                if (!visited.contains(n.val)) {
                    visited.add(n.val);
                    q.offer(n);
                }
            }
            cur.neighbors = neighbors;
        }

        return newNode;
    }

    // Working example
    public Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }

        Node newNode = new Node(node.val);

        // Need use a map instead of HashSet
        Map<Integer, Node> visited = new HashMap<>();
        // also put the newNode in the map;
        visited.put(newNode.val, newNode);

        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node n : cur.neighbors) {
                // neighbors.add(new Node(n.val));
                if (!visited.containsKey(n.val)) {
                    visited.put(n.val, new Node(n.val));
                    q.offer(n);
                }
                // C: here is the key I missing --
                // add the new "Nodes" to the previous (cur) node;
                visited.get(cur.val).neighbors.add(visited.get(n.val));
            }
        }

        return newNode;
    }

    // Inner class can be made private, so it only gonna be used for this problem
    // https://www.tutorialspoint.com/java/java_innerclasses.htm
    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
