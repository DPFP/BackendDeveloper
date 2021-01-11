import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ReverseVowelsInString {

    // Brute Force solution
    public String reverseVowels(String s) {
        if (s.trim().length() <= 1) {
            return s;
        }

        // set all the vowels
        Set<Character> vowels = new HashSet<>();
        vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        // see how many vowels total
        char[] charArray = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (vowels.contains(c)) {
                sb.append(c);
            }
        }
        sb.reverse();

        // loop through replace in-place for vowel only
        int filled = 0;
        for (int i = 0; i < s.length() && filled < sb.length(); i++) {
            if (vowels.contains(charArray[i])) {
                charArray[i] = sb.charAt(filled);
                filled++;
            }
        }

        sb.setLength(0);
        sb.append(charArray);

        System.out.println(sb.toString());

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseVowelsInString sol = new ReverseVowelsInString();

        assert sol.reverseVowels("hello").equalsIgnoreCase("holle") : "T1 failed";
        assert sol.reverseVowels("leetcode").equalsIgnoreCase("leotcede") : "T2 failed";
        assert sol.reverseVowels("aA").equalsIgnoreCase("Aa") : "T3 failed";
    }
}