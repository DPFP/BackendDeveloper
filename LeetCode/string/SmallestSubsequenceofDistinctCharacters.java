import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SmallestSubsequenceofDistinctCharacters {

    // 1st try
    // Does not work, because it not guarantee it is subsequence
    public String smallestSubsequence1st(String s) {
        Set<Character> uniqueChars = new HashSet<>();

        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        StringBuilder sb = new StringBuilder();

        for (char c : uniqueChars) {
            sb.append(c);
        }
        System.out.println(sb.toString());

        return sb.toString();
    }

    // 2nd try
    public String smallestSubsequence(String s) {

        return null;
    }

    // Best solution
    public String smallestSubsequenceBest(String S) {
        Stack<Integer> stack = new Stack<>();
        int[] last = new int[26];
        int[] seen = new int[26];

        for (int i = 0; i < S.length(); ++i) {
            last[S.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < S.length(); ++i) {
            int c = S.charAt(i) - 'a';
            if (seen[c]++ > 0) {
                continue;
            }

            // Trying to understand this part of the code;
            while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek()]) {
                seen[stack.pop()] = 0;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : stack)
            sb.append((char) ('a' + i));
        return sb.toString();
    }

    public static void main(String[] args) {
        SmallestSubsequenceofDistinctCharacters sol = new SmallestSubsequenceofDistinctCharacters();
        System.out.println('z' - 'a');
        System.out.println('A' - 'a');
        System.err.println(Integer.valueOf('a'));
        System.err.println(Integer.valueOf('z'));

        assert sol.smallestSubsequenceBest("cbacdcbc").equals("acdb") == true : "T1 Failed";
        assert sol.smallestSubsequenceBest("bcabc").equals("abc") == true : "T1 Failed";
        // why the output must be "acdb" not "cbad" ==>
        // becasuse "sub-sequence of input string"

    }
}
