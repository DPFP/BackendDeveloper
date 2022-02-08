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
}
