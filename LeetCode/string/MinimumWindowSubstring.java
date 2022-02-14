package LeetCode.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    // 76 Minimum Window Substring
    // https://leetcode.com/problems/minimum-window-substring/

    // Solution from Labuladong : didn't really work :(
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) {
            return "";
        }

        // first put t into a Set, look up O(1); or String.IndexOf() always requires
        // O(n) time.
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (Character c : t.toCharArray()) {
            need.put(c, 1);
        }

        int left = 0;
        int right = 0;

        int valid = 0;
        // substring start & length
        int start = 0;
        int len = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // check after the expansion of window size
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // check if need shrink from left
            while (valid == need.keySet().size()) {
                // update the min. substring indexes
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // d is the character get kicked out of window
                Character d = s.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                        window.put(d, window.get(d) - 1);
                    }
                }
            }

        }

        return len == 0 ? "" : s.substring(start, len);

    }

    // working solution from here
    // https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems/25816
    public String minWindow2(String s, String t) {
        int[] map = new int[128];

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int start = 0;
        int end = 0;

        int minStart = 0;
        int minLen = Integer.MAX_VALUE;

        int counter = t.length();

        int slen = s.length();

        while (end < slen) {
            final char c1 = s.charAt(end);

            if (map[c1] > 0) {
                counter--;
            }
            map[c1]--;
            end++;

            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }

                final char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) {
                    counter++;
                }
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    // 3rd try 2/13/2022
    // good explainnation
    // https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems/25861
    public String minWindow3(String s, String t) {
        // another very typical sliding window problem.
        // Map<Character, Integer> targetMap = new HashMap<>();
        int[] targetMap = new int[128];
        for (char c : t.toCharArray()) {
            // targetMap.put(c, targetMap.getOrDefault(c,0) + 1);
            targetMap[c]++;
        }

        int target = t.length(); // how many we need to statisfy;
        // int count = 0;

        int start = 0;
        int end = 0;

        // missing
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        // missing

        int len = s.length();

        while (end < len) {
            char c1 = s.charAt(end);

            if (targetMap[c1] > 0) {
                target--;
            }

            // targetMap.put(c1, targetMap.get(c1)-1);
            targetMap[c1]--;
            end++;

            while (target == 0) {
                // missing
                // minLen = Math.min(minLen, end - start);
                if (minLen > end - start) { // Key: Update the minLen & minStart
                    minLen = end - start;
                    minStart = start;
                }
                // missing

                char c2 = s.charAt(start); // grab whatever from start index
                // targetMap.put(c2,targetMap.get(c2)+1);
                targetMap[c2]++;
                if (targetMap[c2] > 0) {
                    target++;
                }
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    // LC 340. Longest Substring with At Most K Distinct Characters
    // https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[128];

        int res = Integer.MIN_VALUE;

        int start = 0;
        int end = 0;

        int len = s.length();
        int counter = 0;

        while (end < len) {
            char c1 = s.charAt(end);

            if (map[c1] == 0) { // here is the problem. it is map[c1] == 0;
                counter++;
            }
            map[c1]++;
            end++;
            while (counter > k) {
                char c2 = s.charAt(start);
                if (map[c2] == 1) {
                    counter--;
                }
                map[c2]--;
                start++;
            }
            res = Math.max(res, end - start);
        }
        return res;
    }

    // 159. Longest Substring with At Most Two Distinct Characters
    // https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[128]; // map ASCII

        int start = 0;
        int end = 0;

        int res = Integer.MIN_VALUE;
        int len = s.length();
        int counter = 0;

        while (end < len) {
            char c1 = s.charAt(end);
            if (map[c1] == 0) {
                counter++;
            }
            map[c1]++;
            end++;

            while (counter > 2) {
                char c2 = s.charAt(start);
                if (map[c2] == 1) {
                    counter--;
                }
                map[c2]--;
                start++;
            }

            res = Math.max(res, end - start);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        System.out.println(sol.minWindow3(s, t));
    }
}
