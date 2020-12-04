public class RepeatedStringMatch {

    // return the minimum number of times you should repeat string a so that string
    // b is a substring of it.
    // If it is impossible for b​​​​​​ to be a substring of a after repeating it,
    // return -1.

    // Time Limit Exceeded
    public int repeatedStringMatch(String a, String b) {
        if (a.contains(b)) {
            return 1;
        }

        int time = 1;
        StringBuilder sb = new StringBuilder(a);

        while (!sb.toString().contains(b) && time < Math.max(a.length(), b.length())) {
            sb.append(a);
            time++;
        }

        if (!sb.toString().contains(b)) {
            return -1;
        }

        return time;
    }

    public static void main(String[] args) {
        RepeatedStringMatch sol = new RepeatedStringMatch();
        // 13 mintues
        assert sol.repeatedStringMatch("a", "aa") == 2 : "T6 Failed";
        assert sol.repeatedStringMatch("abcd", "cdabcdab") == 3 : "T1 Failed";
        assert sol.repeatedStringMatch("a", "a") == 1 : "T2 Failed";
        assert sol.repeatedStringMatch("abc", "wxyz") == -1 : "T3 Failed";
        assert sol.repeatedStringMatch("aa", "a") == 1 : "T4 Failed";
        assert sol.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba") == 2 : "T5 Failed";

    }
}
