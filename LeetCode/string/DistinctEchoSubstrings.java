import java.util.HashSet;
import java.util.Set;

public class DistinctEchoSubstrings {

    // Return the number of distinct non-empty substrings of text that can be
    // written as the concatenation of some string with itself (i.e. it can be
    // written as a + a where a is some string).

    // Hint #1 Given a substring of the text, how to check if it can be written as
    // the concatenation of a string with itself ?
    // brute force solution -- Time Limit Exceeded

    // Hint #2 We can do that in linear time, a faster way is to use hashing.
    // Hint #3 Try all substrings and use hashing to check them.

    public int distinctEchoSubstrings(String text) {

        Set<String> entry = new HashSet<>();
        Set<String> valid = new HashSet<>();
        String temp;
        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                // #1 get all the substring "a" of text
                temp = text.substring(i, j);
                if (!entry.contains(temp)) {
                    entry.add(temp);
                    // #2 get the echo string of "a" --> "a + a "
                    if (text.contains(temp + temp)) {
                        // #3 to see if "a + a " is a substring of text
                        valid.add(temp);
                    }
                }
            }
        }
        valid.remove("");
        System.out.println(valid.size());
        return valid.size();
    }

    // online brute force solution
    public int distinctEchoSubstringsBF(String str) {
        HashSet<String> set = new HashSet<>();
        int n = str.length();

        for (int i = 0; i < n; i++) {
            for (int len = 2; i + len <= n; len += 2) {
                int mid = i + len / 2;
                String subStr1 = str.substring(i, mid);
                String subStr2 = str.substring(mid, i + len);
                if (subStr1.equals(subStr2)) {
                    set.add(subStr1);
                }
            }
        }
        return set.size();
    }

    // online hash solution
    // https://leetcode.com/problems/distinct-echo-substrings/discuss/477217/Java-Brute-force-and-Hash-Solution-Clean-code
    long BASE = 29L, MOD = 1000000007L;

    public int distinctEchoSubstringsHash(String str) {
        HashSet<Long> set = new HashSet<>();
        int n = str.length();
        long[] hash = new long[n + 1]; // hash[i] is hash value from str[0..i]
        long[] pow = new long[n + 1]; // pow[i] = BASE^i
        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            hash[i] = (hash[i - 1] * BASE + str.charAt(i - 1)) % MOD;
            pow[i] = pow[i - 1] * BASE % MOD;
        }

        // C: still got O(n^2)
        for (int i = 0; i < n; i++) {
            for (int len = 2; i + len <= n; len += 2) {
                int mid = i + len / 2;
                long hash1 = getHash(i, mid, hash, pow);
                long hash2 = getHash(mid, i + len, hash, pow);
                if (hash1 == hash2)
                    set.add(hash1);
            }
        }
        return set.size();
    }

    long getHash(int l, int r, long[] hash, long[] pow) {
        return (hash[r] - hash[l] * pow[r - l] % MOD + MOD) % MOD;
    }
    // online hash solution

    public static void main(String[] args) {

        DistinctEchoSubstrings sol = new DistinctEchoSubstrings();
        assert sol.distinctEchoSubstrings("abcabcabc") == 3 : "T1 Failed";
        assert sol.distinctEchoSubstrings("leetcodeleetcode") == 2 : "T2 Failed";
        assert sol.distinctEchoSubstrings(
                "tkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnra") == 752
                : "T3 31/39 Failed";
        assert sol.distinctEchoSubstrings(
                "tiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtidux") == 636
                : "T4 16/39 Failed";
    }
}
