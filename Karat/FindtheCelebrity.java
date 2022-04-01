public class FindtheCelebrity {

    // 277. Find the Celebrity
    // https://leetcode.com/problems/find-the-celebrity/

    // YouTube solution
    public int findCelebrity(int n) {
        int possibleCeleb = 0;
        for (int i = 0; i < n; i++) {
            if (knows(possibleCeleb, i)) {
                possibleCeleb = i;
            }
        }
        if (isCeleb(possibleCeleb, n)) {
            return possibleCeleb;
        }
        return -1;
    }

    private boolean isCeleb(int possible, int n) {
        for (int i = 0; i < possible; i++) {
            if (knows(possible, i) || !knows(i, possible)) {
                return false;
            }
        }

        for (int i = possible + 1; i < n; i++) {
            if (!knows(i, possible)) {
                return false;
            }
        }
        return true;
    }

    // from leetcode
    private boolean knows(int possibleCeleb, int i) {
        return false;
    }
}
