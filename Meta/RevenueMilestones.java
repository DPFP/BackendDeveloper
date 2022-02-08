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

    public static void main(String[] args) {
        int revenues_1[] = { 100, 200, 300, 400, 500 };
        int milestones_1[] = { 300, 800, 1000, 1400 };

        Arrays.stream(getMilestoneDays(revenues_1, milestones_1)).forEach(n -> System.out.println(n));
    }
}
