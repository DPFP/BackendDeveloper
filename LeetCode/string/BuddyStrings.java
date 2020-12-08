import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyStrings {

    // Time Limit Exceeded with the following approach
    public boolean buddyStringsTLE(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        String temp = A;
        for (int i = 0; i < A.length(); i++) {
            for (int j = i + 1; j < A.length(); j++) {
                // Swap
                if (A.charAt(i) != A.charAt(j)) {
                    temp = swap(A, i, j);
                } else {
                    temp = A;
                }
                if (temp.equalsIgnoreCase(B)) {
                    return true;
                }
            }
        }
        return false;
    }
    // Time Limit Exceeded with the approach

    public String swap(String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;

        return String.valueOf(ch);
    }

    // 2nd approach -- Time limit still exceeded
    public boolean buddyStrings(String A, String B) {
        // #1 not possible
        if (A.length() != B.length()) {
            return false;
        }

        if (A.equalsIgnoreCase(B)) {
            // #2 if there is same (duplicate char)
            Set<Character> count = new HashSet<>();
            for (char c : A.toCharArray()) {
                count.add(c);
            }
            return count.size() < A.length();
        }

        //#3 swap the difference one
        String temp = A;
        for (int i = 0; i < A.length(); i++) {
            for (int j = i + 1; j < A.length(); j++) {
                // Swap
                if (A.charAt(i) != A.charAt(j)) {
                    temp = swap(A, i, j);
                }
                if (temp.equalsIgnoreCase(B)) {
                    return true;
                }
            }
        }
        return false;
    }

    // LC official solution
    public boolean buddyStringsSol(String A, String B) {

        // Case #1
        if (A.length() != B.length())
            return false;

        // Case #2
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c : count)
                if (c > 1)
                    return true;
            return false;

        } else { // Case #3

            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }
            return (second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first));
        }
    }
    // LC official solution

    // Best solution
    public boolean buddyStringsB(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.equals(B)) {
            Set<Character> s = new HashSet<Character>();
            for (char c : A.toCharArray())
                s.add(c);
            return s.size() < A.length();
        }
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i)
            if (A.charAt(i) != B.charAt(i))
                dif.add(i);
        return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1))
                && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }
    // Best

    public static void main(String[] args) {
        BuddyStrings sol = new BuddyStrings();

        assert sol.buddyStrings("ab", "ba") == true : "T2 failed";
        assert sol.buddyStrings("ab", "ab") == false : "T0 failed";
        assert sol.buddyStrings("abc", "abc") == false : "T1 failed";
        assert sol.buddyStrings("aa", "aa") == true : "T3 failed";
        
        assert sol.buddyStrings("aaaaaaabc", "aaaaaaacb") == true : "T4 failed";
        assert sol.buddyStrings("b", "aa") == false : "T5 failed";
        assert sol.buddyStrings("abab", "abab") == true : "T6 failed";

    }
}
