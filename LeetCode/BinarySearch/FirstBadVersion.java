package LeetCode.BinarySearch;

public class FirstBadVersion {

    // 1st try TLE
    public int firstBadVersion(int n) {
        int res = 1;
        for (int i = 1; i < n + 1; i++) {
            if (isBadVersion(i)) {
                res = i;
                return i;
            }
        }
        return res;
    }

    // online solution Binary Search
    public int firstBadVersion2(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // dummy method
    private boolean isBadVersion(int i) {
        return false;
    }

}