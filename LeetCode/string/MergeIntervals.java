import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    // 56 Merge Intervals https://leetcode.com/problems/merge-intervals/

    // Didn't work on this approach
    public int[][] merge(int[][] intervals) {
        // not sure how large the array going to be;
        // how to merge if only two intervals ?
        // is the intervals sorted ?

        if (intervals.length <= 1) {
            return intervals;
        }

        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (prev[1] >= intervals[i][0] && prev[1] <= intervals[i][1]) {
                intervals[i][0] = prev[0];
                removeElement(intervals, i - 1);
            }
            // System.out.println(intervals[i][0] + " " + intervals[i][1]);
            prev = intervals[i];
        }

        return intervals;
    }

    public void removeElement(Object[] arr, int removedIdx) {
        System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
    }

    // solution from labuladong
    public int[][] merge2(int[][] intervals) {
        // not sure how large the array going to be;
        LinkedList<int[]> res = new LinkedList<>();
        // how to merge if only two intervals ?

        // is the intervals sorted ? No, sort it by the "start" asceding
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        res.add(intervals[0]);

        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            // from last pair/interval. aka, previous interval
            int[] last = res.getLast();

            // if the start of current is smaller than end of last;
            if (curr[0] <= last[1]) {
                // find which end is bigger; e.g. [1,5] & [2,4] or [1,3] & [3,5]
                last[1] = Math.max(last[1], curr[1]);
                // notice here didn't add new int[] to the list (as curr already been merged to
                // pre/last)
            } else {
                res.add(curr);
            }
        }

        return res.toArray(new int[0][0]);
    }

    // similar approach
    public int[][] merge3(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];

        result.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else { // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    // re-try on 1/23
    public int[][] merge4(int[][] intervals) {
        // first sort the array by start. and then check the end with next

        // List<int[]> res = new LinkedList<>();
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // missing
        res.add(intervals[0]);
        // missing

        // for(int i=1; i<intervals.length; i++){
        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            // initial intervals[0]
            int[] pre = res.getLast();

            // there is overlapping with previous
            if (curr[0] <= pre[1]) {
                // int[] interval = new int[2];
                // interval[0] = intervals[i-1][0];
                // interval[1] = Math.max(intervals[i-1][1],intervals[i][1]);
                pre[1] = Math.max(curr[1], pre[1]);
                // res.add(interval);
            } else {
                res.add(curr);
            }
        }

        return res.toArray(new int[0][0]);
    }
}
