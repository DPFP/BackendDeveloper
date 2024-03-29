import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
    // 435 Non-overlapping Intervals
    // https://leetcode.com/problems/non-overlapping-intervals/
    // https://leetcode.com/problems/non-overlapping-intervals/discuss/91713/Java%3A-Least-is-Most

    // Labuladong solution - Runtime is pretty bad
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        return n - intervalSchedule(intervals);
    }

    // figure out how many can be scheduled without overlapping
    private int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) {
            return 0;
        }

        // 按 end 升序排序
        Arrays.sort(intvs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        // Or the following short-cut 6, 7, 9 , 10
        // Arrays.sort(intvs, Comparator.comparingInt(i -> i[1]));
        // Arrays.sort(intvs, (a, b)-> a[1]-b[1]);
        // Arrays.sort() vs. Collections.sort()
        // at least one interval don't overlapping
        int count = 1;

        // first X interval
        int x_end = intvs[0][1];

        for (int[] interval : intvs) {
            int start = interval[0];
            // if next interval is behind X
            if (start >= x_end) {
                count++;
                x_end = interval[1];
            }
        }

        return count;
    }

    // Tried again on 1/14/2022
    // 85.99% & 51.78% --> a little improvement over yesterday
    public int eraseOverlapIntervals2(int[][] intervals) {
        int len = intervals.length;

        return len - scheduledIntervals(intervals);
    }

    private int scheduledIntervals(int[][] intervals) {
        int x_end = 0;
        int count = 1; // always will have one interval

        // sort the Interval by it ending asceding
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // start 排序后，第一个区间就是 x
        x_end = intervals[0][1];

        for (int[] interval : intervals) {
            if (x_end <= interval[0]) { // 找到下一个选择的区间了
                count++;
                x_end = interval[1]; // update x_end
            }
        }

        return count;
    }
}
