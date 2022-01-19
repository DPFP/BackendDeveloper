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
}
