import java.util.Arrays;

public class MeetingRooms {

    // 252 Meeting Rooms (Leetcode Premium)
    // https://leetcode.com/problems/meeting-rooms/

    // BF solution - worked , pretty sure there is other way can work without
    // sorting
    public boolean canAttendMeetings(int[][] intervals) {
        // try sort by start date --> if end overlapping, then it false;

        if (intervals == null || intervals.length == 0) {
            return false;
        }

        // first sort
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int curEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (curEnd > intervals[i][0]) {
                return false;
            }
            curEnd = intervals[i][1];
        }

        return true;
    }
}
