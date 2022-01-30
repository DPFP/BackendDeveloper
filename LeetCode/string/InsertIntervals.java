import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {

    // intial try didn't work
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // two pointers
        // three cases
        // 1, anything before newInterval[0] (left) will be it own;
        // 2, anything overlapping <- n[0] & n[1] -> will be merged
        // 3, anything after n[1] will be it own;

        List<int[]> res = new ArrayList<>();

        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[res.size()][]);
        }

        int mergedStart = 0;
        int mergedEnd = 0;

        int len = intervals.length;

        for (int i = 0; i < len; i++) {
            if (intervals[i][0] < newInterval[0]) {
                res.add(intervals[i]);
                continue; // skip the following
            } else if (intervals[i][0] < newInterval[0] && intervals[i][1] > newInterval[0]) {
                mergedStart = intervals[i][0];
            } else if (intervals[i][0] <= newInterval[1] && intervals[i][1] > newInterval[1]) {
                mergedEnd = intervals[i][1];
            } else if (intervals[i][1] > newInterval[1]) {
                res.add(intervals[i]);
                continue; // skip the following
            }
            // how to skip the interval in between ?

            // add it to the results
            res.add(new int[] { mergedStart, mergedEnd });
        }

        return res.toArray(new int[res.size()][]);
    }

    // worked solution
    // https://leetcode.com/problems/insert-interval/discuss/21602/Short-and-straight-forward-Java-solution/229449
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        // if(intervals == null || intervals.length == 0){
        // return res.toArray(new int[res.size()][]);
        // }

        int mergedStart = newInterval[0];
        int mergedEnd = newInterval[1];

        int len = intervals.length;
        int i = 0;

        // add anything that is smaller than(before) "start"
        while (i < len && intervals[i][1] < mergedStart) {
            res.add(intervals[i++]);
        }

        // if interval is within the range
        while (i < len && intervals[i][0] <= mergedEnd) {
            mergedStart = Math.min(mergedStart, intervals[i][0]);
            mergedEnd = Math.max(mergedEnd, intervals[i][1]);
            i++;
        }

        res.add(new int[] { mergedStart, mergedEnd });

        // add the remaining items. LOL
        // while(i < len && intervals[i][0] > mergedEnd )
        while (i < len) {
            res.add(intervals[i++]);
        }

        return res.toArray(new int[res.size()][]);
    }

    // tried on 1/29, can we try covert the while loop to for loop ?
    public int[][] insert4(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int len = intervals.length;
        int i = 0;

        int mergedStart = newInterval[0];
        int mergedEnd = newInterval[1];

        // 1st, is go through everything that is less than start (n[0]);
        while (i < len && (intervals[i][1] < mergedStart)) {
            res.add(intervals[i++]);
        }

        // to this point, all value are intervals[i][1] > mergedStart,

        // 2nd, any value in between.
        // ??? here is the part I struggle with. --> also check intervals[i][0] < end
        // (means overlapping) key: (intervals[i][0] <= mergedEnd)
        // while(i < len && (intervals[i++][0] < mergedEnd)){
        while (i < len && (intervals[i][0] <= mergedEnd)) {
            mergedStart = Math.min(mergedStart, intervals[i][0]);
            // mergedEnd = Math.max(mergedEnd, intervals[i][0]);
            mergedEnd = Math.max(mergedEnd, intervals[i][1]);
            i++;
        }
        res.add(new int[] { mergedStart, mergedEnd });

        // 3rd, remaining items, intervals[i][0] > mergedEnd
        while (i < len) {
            res.add(intervals[i++]);
        }

        return res.toArray(new int[res.size()][]);
    }

    // this one is a little hard to understand
    // https://leetcode.com/problems/insert-interval/discuss/959756/Java-1ms-easy-line-by-line-explanation
    public int[][] insert3(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        // Iterate through all slots
        for (int[] slot : intervals) {
            // if newInterval before slot insert newInterval & update slot as new interval
            if (newInterval[1] < slot[0]) {
                result.add(newInterval);
                newInterval = slot;
            } else if (slot[1] < newInterval[0]) {
                // if slot is lesser than new Interval insert slot
                result.add(slot);
            }
            // if above conditions fail its an overlap since possibility of new interval
            // existing in left & right of slot is checked
            // update lowest of start & highest of end & not insert
            else {
                newInterval[0] = Math.min(newInterval[0], slot[0]);
                newInterval[1] = Math.max(newInterval[1], slot[1]);
            }
        }

        // insert the last newInterval
        result.add(newInterval);

        // convert to int[][] array
        return result.toArray(new int[result.size()][]);
    }
}
