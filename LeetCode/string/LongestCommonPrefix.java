public class LongestCommonPrefix {

    // idea: a~z - a~z - a~z ... ditionary (Trie-->Autocomplete) overkill ?
    public String longestCommonPrefixBF(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs.length < 1) {
            return result.toString();
        }
        // start with the shortest string
        String shortestString = "";
        int shortest = 200;
        for (String s : strs) {
            if (s.length() < shortest) {
                shortest = s.length();
                shortestString = s;
            }
        }

        int index = 0;
        outerloop: while (shortestString.length() > 0 && index < shortestString.length()) {
            char current = shortestString.charAt(index);
            boolean isCommon = true;
            for (String s : strs) {
                if (!(s.charAt(index) == current)) {
                    isCommon = false;
                    break outerloop;
                }
            }
            if (isCommon) {
                result.append(current);
                index++;
            }
        }

        System.out.println(result.toString());
        return result.toString();
    }

    // second try memory usage could be improved
    public String longestCommonPrefix(String[] strs) {

        // #1 probably still need start with the shortest string

        // #2 loop through each string and check against the shortest break right away
        // if find discrepancy

        return "";
    }

    // LC solution #1 (Horizontal scanning)
    public String longestCommonPrefixSolOne(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // get the first word as prefix
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            // compare the value
            while (strs[i].indexOf(prefix) != 0) {
                // remove last character from the prefix
                prefix = prefix.substring(0, prefix.length() - 1);
                // no common string was found
                if (prefix.isEmpty())
                    return "";
            }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        String[] strs2 = { "dog", "racecar", "car" };
        String[] strs3 = { "cir", "car" };

        LongestCommonPrefix sol = new LongestCommonPrefix();

        String result = sol.longestCommonPrefix(strs);
        assert result.compareToIgnoreCase("fl") == 0 : "T1 failed:" + result;

        result = sol.longestCommonPrefix(strs2);
        assert result.compareToIgnoreCase("") == 0 : "T2 failed:" + result;

        result = sol.longestCommonPrefix(strs3);
        assert result.compareToIgnoreCase("c") == 0 : "T3 failed:" + result;

        // System.out.println(strs[0].substring(1, strs[0].length()));
    }
}
