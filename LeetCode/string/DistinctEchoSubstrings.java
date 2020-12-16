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
    public int distinctEchoSubstrings(String text) {
        // #1 get all the substring "a" of text
        // #2 get the echo string of "a" --> "a + a "
        // #3 to see if "a + a " is a substring of text
        Set<String> valid = new HashSet<>();
        String temp;
        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                temp = text.substring(i, j);
                if (text.contains(temp + temp)) {
                    valid.add(temp);
                    // System.out.println(temp);
                }
            }
        }
        valid.remove("");
        System.out.println(valid.size());
        return valid.size();
    }

    public static void main(String[] args) {

        DistinctEchoSubstrings sol = new DistinctEchoSubstrings();
        assert sol.distinctEchoSubstrings("abcabcabc") == 3 : "T1 Failed";
        assert sol.distinctEchoSubstrings("leetcodeleetcode") == 2 : "T1 Failed";
        assert sol.distinctEchoSubstrings(
                "tiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtidux") == 2
                : "T1 Failed";
    }
}
