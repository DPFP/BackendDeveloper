import java.util.Arrays;

public class RevenueMilestones {

    // first try, didn't work;
    static int[] getMilestoneDays(int[] revenues, int[] milestones) {
        // Write your code here
        int lenMS = milestones.length;
        int lenRev = revenues.length;

        int[] res = new int[lenMS];

        int sum = 0;
        int day = 1;

        for (int i = 0; i < lenMS; i++) {
            // ms <> sum
            for (int rev : revenues) {
                sum += rev;
                day++;
                if (sum >= milestones[i]) {
                    res[i] = day;
                    break;
                } else {
                    res[i] = -1;
                }
            }
        }
        return res;
    }

    // shity PreFixSum soltuion
    // https://leetcode.com/discuss/interview-question/1188322/Facebook-or-Recruiting-Portal-or-Revenue-Milestones/1111864
    int[] getMilestoneDays2(int[] revenues, int[] milestones) {
        // Write your code here
        // use preFixSum
        int lenR = revenues.length;
        int[] preFixSum = new int[lenR];
        int[] res = new int[milestones.length];

        preFixSum[0] = revenues[0];
        for (int i = 1; i < lenR; i++) {
            preFixSum[i] = preFixSum[i - 1] + revenues[i];
        }

        // this part should replaced by Biary Search;
        for (int n = 0; n < milestones.length; n++) {
            for (int i = 0; i < lenR; i++) {
                if (preFixSum[i] >= milestones[n]) {
                    res[n] = i + 1;
                    break;
                }
            }
        }

        return res;
    }

    // 3rd try with Binary Search
    private static int[] getMilestoneDays3(int[] revenues, int[] milestones) {
        // Write your code here
        // use preFixSum
        int lenR = revenues.length;
        int[] preFixSum = new int[lenR];
        int[] res = new int[milestones.length];

        preFixSum[0] = revenues[0];
        for (int i = 1; i < lenR; i++) {
            preFixSum[i] = preFixSum[i - 1] + revenues[i];
        }

        // uss binary search instead;
        for (int i = 0; i < milestones.length; i++) {
            // res[i] = binarySearch(preFixSum, milestones[i]);
            res[i] = binarySearch(preFixSum, milestones[i]) + 1; // the next day !
        }

        return res;
    }

    private static int binarySearch(int[] preFixSum, int target) {
        int left = 0;
        int right = preFixSum.length - 1;

        while (left < right) {
            // int mid = (left + right)/2;
            int mid = left + (right - left) / 2; // This to accommodate for extremely large arrays.

            // slightly modified binary search. instead of finding the exactly target
            // this will find the left closest to the target instead
            if (preFixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // key pint is right here, if it exceed right, means nothingt found.
        // seems didn't hanlde -1 ?
        return (left < preFixSum.length ? left : -1);
    }

    public static void main(String[] args) {
        int revenues_1[] = { 100, 200, 300, 400, 500 };
        int milestones_1[] = { 300, 800, 1000, 1400 };

        Arrays.stream(getMilestoneDays3(revenues_1, milestones_1)).forEach(n -> System.out.println(n));
    }
}
