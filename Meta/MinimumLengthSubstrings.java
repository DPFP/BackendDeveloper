import java.util.HashMap;
import java.util.Map;

public class MinimumLengthSubstrings {

    int minLengthSubstring(String s, String t) {
        // Write your code here
        // this is really asking for subsequence, right ? as long as the min-substring
        // contains the t.
        // If it is not possible, return -1
        // two pointer/sliding window

        // is it all alhenumic ? if yes, we can use int[] map = new int[128];

        // Key: character, value: count
        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, 1);
        }

        int res = Integer.MAX_VALUE; // minLen

        int start = 0;
        int end = 0;

        int matchCount = t.length(); // how many need to satify;
        int slen = s.length();

        // missing not needed fro this problem. (only needed count, not subString)
        // int minStart = 0;

        // how to determine if i find one ? Use either int[] map = new int[128] 128 ==>
        // ASCII or HashMap
        while (end < slen) {
            final char c1 = s.charAt(end);
            if (map.containsKey(c1) && map.get(c1) > 0) {
                matchCount--;
            }
            map.put(c1, map.getOrDefault(c1, 0) - 1);
            end++;

            // until we find all matheces,then start to moving left pointer to shrink
            while (matchCount == 0) {
                res = Math.min(res, end - start);
                final char c2 = s.charAt(start);
                map.put(c2, map.get(c2) + 1);
                if (map.get(c2) > 0) {
                    matchCount++;
                }
                start++;
            }

        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        String s = "dcbefebce";
        String t = "fd";

        System.out.println(s.contains(t));
    }
}
