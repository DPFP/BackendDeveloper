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

    //Coplit's solution - O(n) time and O(1) space (2021-7-13)
    public String reverseVowels2(String s) {
        if (s.trim().length() <= 1) {
            return s;
        }
        char[] charArray = s.toCharArray();
        int i = 0;
        int j = charArray.length - 1;
        while (i < j) {
            while (i < j && !isVowel(charArray[i])) {
                i++;
            }
            while (i < j && !isVowel(charArray[j])) {
                j--;
            }
            if (i < j) {
                charArray[i] = charArray[j];
                charArray[j] = charArray[i];
                i++;
                j--;
            }   
        }
        return new String(charArray);
    }


    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    

    public static void main(String[] args) {
        ReverseVowelsInString sol = new ReverseVowelsInString();

        assert sol.reverseVowels("hello").equalsIgnoreCase("holle") : "T1 failed";
        assert sol.reverseVowels("leetcode").equalsIgnoreCase("leotcede") : "T2 failed";
        assert sol.reverseVowels("aA").equalsIgnoreCase("Aa") : "T3 failed";
    }
}