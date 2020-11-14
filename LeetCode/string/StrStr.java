public class StrStr {
    // Return the index of the first occurrence of needle in haystack, or -1 if
    // needle is not part of haystack.

    public int strStr(String haystack, String needle) {
        if (needle.isBlank()) {
            return 0;
        }

        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        StrStr sol = new StrStr();

        assert sol.strStr("hello", "ll") == 2 : "Failed T1";
        assert sol.strStr("aaaaa", "bbba") == -1 : "Failed T2";
        assert sol.strStr("", "") == 0 : "Failed T3";
        assert sol.strStr("", "a") == -1 : "Failed T4";
        assert sol.strStr("mississippi", "issip") == 4 : "Failed T5";
    }
}
