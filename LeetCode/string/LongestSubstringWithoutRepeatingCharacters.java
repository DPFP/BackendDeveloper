import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    // 3 Longest Substring Without Repeating Characters
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    // my own solution didn't work :(
    public int lengthOfLongestSubstring(String s) {
        // another sliding window but opposite of 424 ? + HashSet ?
        // Notice: s consists of English letters, digits, symbols and spaces.
        Set<Character> track = new HashSet<>();

        int len = s.length();
        int start = 0;
        int res = 0;

        for (int end = 0; end < len; end++) {
            if (track.contains(s.charAt(end))) {
                track.remove(s.charAt(start)); // ?
                start++;
            } else {
                track.add(s.charAt(end));
                res = Math.max(res, track.size());
            }
        }

        return res;
    }

    // Worked solution from
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1812/Share-my-Java-solution-using-HashSet
    public int lengthOfLongestSubstring2(String s) {
        // another sliding window but opposite of 424 ? + HashSet ?
        // Notice: s consists of English letters, digits, symbols and spaces.
        Set<Character> track = new HashSet<>();

        int len = s.length();

        int start = 0;
        int end = 0;

        int res = 0;

        while (end < len) {
            if (!track.contains(s.charAt(end))) {
                // notice the "end++" here ; end will only be moving if doesn't repeat;
                track.add(s.charAt(end++));
                res = Math.max(res, track.size());
            } else {
                track.remove(s.charAt(start++));
            }
        }

        return res;
    }

    // solution based on the sliding window tempalte
    // https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
    public int lengthOfLongestSubstring3(String s) {
        int[] map = new int[128]; // ascii

        int start = 0;
        int end = 0;

        int counter = 0;
        int len = s.length();

        int res = Integer.MIN_VALUE;

        while (end < len) {
            char c1 = s.charAt(end);
            if (map[c1] > 0) { // > 0 means there is repeating character.
                counter++;
            }
            map[c1]++;
            end++;

            while (counter > 0) { // if find any repeating character, move/shrink left pointer;
                char c2 = s.charAt(start);
                if (map[c2] > 1) {
                    counter--;
                }
                map[c2]--;
                start++;
            }

            res = Math.max(res, end - start); // update the result
        }

        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
