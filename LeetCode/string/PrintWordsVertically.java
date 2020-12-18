import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {
    // Given a string s. Return all the words vertically in the same order in which
    // they appear in s.
    // (Trailing spaces are not allowed).

    // brute force solution
    public List<String> printVertically(String s) {
        // #1 split the String s into words, split("") or split(regex)
        String[] words = s.split(" ");
        // #1.1 record the longest word length X (will use it later) [determine the
        // output list length]
        int longestWord = 0;
        for (String word : words) {
            if (word.length() > longestWord) {
                longestWord = word.length();
            }
        }

        String regex = "\\s+$";
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        // #2 loop through X and add empty space as necessary
        for (int i = 0; i < longestWord; i++) {
            sb.setLength(0);
            for (String word : words) {
                if (i < word.length()) {
                    sb.append(word.charAt(i));
                } else {
                    sb.append(" ");
                }
            }
            // #3 remove trailing space
            String trimmedString1 = sb.toString().replaceAll(regex, "");
            System.out.println(trimmedString1);
            result.add(trimmedString1);
        }
        return result;
    }

    public static void main(String[] args) {
        PrintWordsVertically sol = new PrintWordsVertically();
        sol.printVertically("HOW ARE YOU");
        sol.printVertically("TO BE OR NOT TO BE");
        sol.printVertically("CONTEST IS COMING");
    }
}
