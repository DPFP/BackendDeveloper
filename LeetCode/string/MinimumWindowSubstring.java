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
}
