public class ContainerWithMostWater {
    // 11 Container With Most Water
    // https://leetcode.com/problems/container-with-most-water/

    // solution from labuladong . not too bad too mimic
    public int maxArea(int[] height) {
        // two pointer - 2nd try 1/17
        int left = 0;
        int right = height.length - 1;

        int res = 0;

        // < or <= ?
        while (left <= right) {
            // notice here is Math.min(height[left], height[right]);
            int cur_area = Math.min(height[left], height[right]) * (right - left); // h * w
            res = Math.max(res, cur_area);

            // instead of comparing with a target, we compare left & right directly
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
