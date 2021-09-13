import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Sept12th {

    public int reachableNodes2(int[][] edges, int maxMoves, int n) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        for (int i = 0; i < maxMoves; i++) {
            int[] newDist = new int[n];
            for (int j = 0; j < n; j++) {
                newDist[j] = dist[j];
            }
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + 1) {
                    newDist[v] = dist[u] + 1;
                }
            }
            dist = newDist;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                count++;
            }
        }
        return count;
    }

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        // https://github.com/cherryljr/LeetCode/blob/master/Reachable%20Nodes%20In%20Subdivided%20Graph.java
        // Build the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[] { edge[1], edge[2] + 1 });
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(new int[] { edge[0], edge[2] + 1 });
        }

        // {node, hp}, sort by HP desc
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        // node -> max HP(step) left
        Map<Integer, Integer> hpMap = new HashMap<>();
        maxHeap.offer(new int[] { 0, maxMoves });

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int pos = curr[0], hp = curr[1];
            if (hpMap.containsKey(pos)) {
                continue;
            }

            hpMap.put(pos, hp);
            if (graph.containsKey(pos)) {
                for (int[] neigh : graph.get(pos)) {
                    int nextPos = neigh[0], nextHp = hp - neigh[1];
                    // skip the visited node or the node that can't reach
                    if (hpMap.containsKey(nextPos) || nextHp < 0) {
                        continue;
                    }
                    maxHeap.offer(new int[] { nextPos, nextHp });
                }
            }
        }

        int rst = hpMap.size(); // Original nodes covered
        for (int[] edge : edges) {
            int u = hpMap.getOrDefault(edge[0], 0);
            int v = hpMap.getOrDefault(edge[1], 0);
            rst += Math.min(edge[2], u + v);
        }
        return rst;
    }

    public static void main(String[] args) {
        Sept12th sept12th = new Sept12th();
        System.out.println(sept12th.reachableNodes(new int[][] { { 0, 1, 10 }, { 0, 2, 1 }, { 1, 2, 2 } }, 6, 3));

    }
}
