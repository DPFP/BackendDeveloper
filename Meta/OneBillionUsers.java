public class OneBillionUsers {

    // should used binary search isntead. (between 1 ~ Upper limit )
    // https://leetcode.com/discuss/interview-question/746520/facebook-recruiting-portal-1-billion-users
    // 1st try solution.
    int getBillionUsersDay(float[] growthRates) {
        // Write your code here
        // 1.5 ^ 52 = 1,434,648,375.48 (1.4billion)
        int sum = 0; // 1000000000;
        int count = 0;

        while (sum < 1000000000) {
            sum = 0;
            count++;
            for (float f : growthRates) {
                sum += Math.pow(f, count);
            }
        }

        return count;
    }

    // 2nd try with binary search appraoch
    int getBillionUsersDay2(float[] growthRates) {
        // Write your code here
        // 1.5 ^ 52 = 1,434,648,375.48 (1.4billion)
        int target = 1000000000;
        int sum = 0; // 1000000000;

        int lower = 0;
        int upper = 2000; // maybe enough

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            sum = 0;

            for (float f : growthRates) {
                sum += Math.pow(f, mid);
            }

            if (sum < target) {
                lower = mid + 1;
            } else {
                upper = mid;
                // and you can't break from here;
            }
        }
        // whu not need + 1 ? because we alreayd have lower = mid + 1;
        return lower;
    }
}
