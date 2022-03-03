package JavaBasic.LeetCode.string;

public class LongestUncommonSubsequence {

    public int findLUSlength(String a, String b) {
        int la = 0;
        for (char c : a.toCharArray()) {
            if (b.indexOf(c) < 0) {
                la++;
            }
        }

        int lb = 0;
        for (char c : b.toCharArray()) {
            if (a.indexOf(c) < 0) {
                lb++;
            }
        }

        System.out.println(la + " " + lb);

        if (la > 0 || lb > 0) {
            if (la > lb) {
                return lb;
            } else {
                return la;
            }
        } else {
            return -1;
        }
    }

    // Best Solution
    public int findLUSlengthBest(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(1 << s.length());

        LongestUncommonSubsequence sol = new LongestUncommonSubsequence();
        assert sol.findLUSlength("abc", "efg") == 3 : "T1 failed";
        assert sol.findLUSlength("aaa", "aaa") == -1 : "T2 failed";
        assert sol.findLUSlength("aaa", "bbb") == 3 : "T3 failed";
        // TODO failed case
        assert sol.findLUSlength("aefawfawfawfaw", "aefawfeawfwafwaef") == 4 : "T4 failed";
    }
}
