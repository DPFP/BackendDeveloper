import java.util.HashSet;
import java.util.Set;

public class MatchingPairs {
    // 1st try
    private static int matchingPairs(String s, String t) {
        // Write your code here
        // Note: This means you must swap two characters at different indices. in s

        // Scenario #1 -- s == t -- value: s.length - 2
        if (s.equalsIgnoreCase(t)) {
            return s.length() - 2;
        }

        // scenario #2 -- s != t -- matching Count + two (unmatched character)
        // as long as there two characters differe within s & t
        int counter = 0;
        int misMatchCount = 0;

        int len = s.length();

        Set<Character> misMatchSet = new HashSet<>();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                counter++;
            } else {
                if (!misMatchSet.add(s.charAt(i))) {
                    misMatchCount++;
                }
                ;
                if (!misMatchSet.add(t.charAt(i))) {
                    misMatchCount++;
                }
            }
        }

        if (misMatchCount > 1) {
            counter += 2;
        }

        return counter;
    }

    public static void main(String[] args) {
        String s = "abbccddefefef";
        String t = "abbccddfefefe";

        System.out.println(matchingPairs(s, t));
    }
}
