import java.util.HashSet;
import java.util.Set;

public class SmallestSubsequenceofDistinctCharacters {

    public String smallestSubsequence(String s) {
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

    public static void main(String[] args) {
        SmallestSubsequenceofDistinctCharacters sol = new SmallestSubsequenceofDistinctCharacters();

        assert sol.smallestSubsequence("bcabc").equals("abc") == true : "T1 Failed";
        assert sol.smallestSubsequence("cbacdcbc").equals("acdb") == true : "T1 Failed";
    }
}
