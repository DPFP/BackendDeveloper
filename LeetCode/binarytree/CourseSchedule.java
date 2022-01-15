import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
    // 207 Course Schedule
    // https://leetcode.com/problems/course-schedule/

    // solution from labuladong --definitely need more time to digest
    // https://labuladong.gitee.io/plugin-v3/?qno=207&target=gitee&_=1642216446883

    boolean hasCycle = false;
    boolean[] visited;
    boolean[] onPath;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCycle;
    }

    private void traverse(List<Integer>[] graph, int i) {
        if (onPath[i]) {
            hasCycle = true;
            return;
        }

        if (visited[i]) {
            return;
        }

        visited[i] = true;
        onPath[i] = true;

        // going down for each edge --> DFS
        for (int t : graph[i]) {
            traverse(graph, t);
        }

        // backtracking
        onPath[i] = false;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        // the following is interesting ...
        List<Integer>[] graph = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];

            graph[from].add(to);
        }

        return graph;
    }
}
