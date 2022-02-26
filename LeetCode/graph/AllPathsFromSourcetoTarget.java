package LeetCode.graph;

import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourcetoTarget {
    // 797 All Paths From Source to Target
    // https://leetcode.com/problems/all-paths-from-source-to-target/

    // solution from labuladong
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // used to keep track of current path
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);

        return res;
    }

    private void traverse(int[][] graph, int n, LinkedList<Integer> path) {
        // keep track of current path
        path.addLast(n);

        int end = graph.length - 1;
        if (n == end) {
            // reached to end of graph
            res.add(new LinkedList<>(path));
            path.removeLast(); // ??? why need do this here ? backtracking

            return;
        }

        // keep going through the vertices --> DFS
        for (int v : graph[n]) {
            traverse(graph, v, path);
        }

        path.removeLast();
    }
}