import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodesInaSubtree {
    // Tree Node
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Query {
        int u;
        char c;

        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }

    // Add any helper functions you may need here

    int counter = 0;

    // first try
    int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        // Write your code here
        // The query result is the number of nodes in the subtree of node u containing
        // c.

        int[] res = new int[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            // find the tree;
            Node cur = findTree(root, queries.get(i).u);

            // calculate the element
            counter = 0;
            countTheChar(cur, queries.get(i).c);
        }

        return res;

    }

    private void countTheChar(Node node, char c) {
        if (node == null) {
            return;
        }

    }

    private Node findTree(Node start, int val) {
        if (start == null) {
            return null;
        }

        if (start.val == val) {
            return start;
        }

        // Node left = findTree(start.left, val);
        // Node right = findTree(start.right, val);

        // return left == null ? right : left;
        return null;
    }

    // LC solution -- idea is simple, implementation is quite hard
    // https://leetcode.com/discuss/interview-question/756125/Facebook-or-Recruiting-Portal-or-Nodes-in-a-Subtree/776736
    private Map<Character, Integer> dfs(Node node, String s, Map<Integer, Map<Character, Integer>> countMap) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        charCountMap.put(s.charAt(node.val - 1), 1); // 1-based index, so have to -1 here

        for (Node child : node.children) {
            for (Map.Entry<Character, Integer> entry : dfs(child, s, countMap).entrySet()) {
                // this line is a little bit hard for me to understand
                charCountMap.put(entry.getKey(), charCountMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }
        countMap.put(node.val, charCountMap);

        return charCountMap;
    }

    int[] countOfNodes2(Node root, ArrayList<Query> queries, String s) {
        // Write your code here
        int[] res = new int[queries.size()];

        Map<Integer, Map<Character, Integer>> countMap = new HashMap<>();
        dfs(root, s, countMap);

        int index = 0;
        for (Query q : queries) {
            res[index++] = countMap.get(q.u).getOrDefault(q.c, 0);
        }

        return res;
    }

    // solution No.3
    // https://leetcode.com/discuss/interview-question/756125/Facebook-or-Recruiting-Portal-or-Nodes-in-a-Subtree/860426
    // C: had similar thoughts, but won't able to implement it
    private int getCount(Node node, Query q, String s) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (s.charAt(node.val - 1) == q.c) {
            count++;
        }
        for (Node child : node.children) {
            count += getCount(child, q, s);
        }
        return count;
    }

    private Node findNode(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        for (Node child : root.children) {
            Node found = findNode(child, val);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    // probabbly is the best solution
    int[] countOfNodes3(Node root, ArrayList<Query> queries, String s) {
        int[] result = new int[queries.size()];
        int i = 0;
        for (Query q : queries) {
            Node node = findNode(root, q.u);
            result[i++] = getCount(node, q, s);
        }
        return result;
    }

}
