public class LongestRepeatingCharacterReplacement {
    // 424 Longest Repeating Character Replacement
    // https://leetcode.com/problems/longest-repeating-character-replacement/

    // no idea yet; guess another two pointer ? Close, but using Sliding Window
    // what would human do ? Start from left to right, flip letter and then check
    // the length ?

    // Solution from here
    // https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O(n)-sliding-window-solution-with-explanation
    // sliding window
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26]; // map for counting all 26 chars
        int start = 0; // leftPointer
        // maxCount = largest count of a single, unique character in the current window
        int maxCount = 0;
        int maxLength = 0;

        // end ==> rightPointer, keep moving to the right to increase the window size
        for (int end = 0; end < len; end++) {
            // increase the account for "cur character"
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);

            // sliding window -- windo is not valid, move the leftPointer to right &
            // decrease count. Shrink the window size.
            // C: this is reversed than the original video tutorial have shown
            if (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }

            // end-start+1 = size of the current window
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    // more precise version
    // https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O(n)-sliding-window-solution-with-explanation/95833
    public int characterReplacement2(String s, int k) {
        int max = 0;
        int start = 0;
        int[] count = new int[128];
        for (int end = 0; end < s.length(); end++) {
            // only keep track of the top frequency value
            max = Math.max(max, ++count[s.charAt(end)]);
            // then compare the (maxFre + k) with the window size (e.g. A-4 + k=2 --> 6 )
            if (max + k <= end - start) {
                // shrink the window inside here with "start++";
                count[s.charAt(start++)]--;
            }
        }
        return s.length() - start;
    }

    // lee215
    // https://leetcode.com/problems/longest-repeating-character-replacement/discuss/278271/JavaC%2B%2BPython-Sliding-Window-just-O(n)
    public int characterReplacement3(String s, int k) {
        int res = 0, maxf = 0, count[] = new int[128];
        for (int i = 0; i < s.length(); ++i) {
            maxf = Math.max(maxf, ++count[s.charAt(i)]);
            if (res - maxf < k) {
                res++;
            } else {
                count[s.charAt(i - res)]--;
            }
        }
        return res;
    }

}
