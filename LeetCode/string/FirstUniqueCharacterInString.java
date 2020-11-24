import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

    // Brute Force --> Can't handle "cc" "cccc"
    public int firstUniqChar(String s) {
        if (s.trim().isEmpty()) {
            return -1;
        }

        if (s.trim().length() == 1) {
            return 0;
        }

        // loop through and check & set flag
        boolean isUnqiue = true;
        for (int i = 0; i < s.length(); i++) {
            isUnqiue = true;
            inner: for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    isUnqiue = false;
                    // curent loop ?
                    break inner;
                }
            }
            if (isUnqiue) {
                System.out.println(i);
                return i;
            }

        }

        return -1;
    }

    // Solution
    public int firstUniqCharSol(String s) {
        if (s.trim().isEmpty()) {
            return -1;
        }

        if (s.trim().length() == 1) {
            return 0;
        }

        Map<Character, Integer> cm = new HashMap<>();
        for (char c : s.toCharArray()) {
            cm.put(c, cm.getOrDefault(c, 0) + 1);
        }

        // Stupid this not gonna work
        // for (Character key : cm.keySet()) {
        // if (cm.get(key) == 1) {
        // int i = s.indexOf(key);
        // System.out.println(i);
        // return i;
        // }
        // }

        for (int i = 0; i < s.length(); i++) {
            if (cm.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInString sol = new FirstUniqueCharacterInString();
        assert sol.firstUniqCharSol("leetcode") == 0 : "T1 Failed";
        assert sol.firstUniqCharSol("loveleetcode") == 2 : "T2 Failed";
        assert sol.firstUniqCharSol("cc") == -1 : "T3 Failed";
    }
}
