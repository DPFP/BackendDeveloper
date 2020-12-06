import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoatLatin {

    // A sentence S is given, composed of words separated by spaces. (lower & upper)

    // If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of
    // the word.

    // If a word begins with a consonant (i.e. not a vowel), remove the first letter
    // and append it to the end, then add "ma".

    // Add one letter 'a' to the end of each word per its word index in the
    // sentence, starting with 1. (For example, the first word gets "a" added to the
    // end, the second word gets "aa" added to the end and so on.)

    public String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet<>();
        vowel.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        // #1 split string to words list
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();

        // #2 go through conditions
        for (int i = 0; i < words.length; i++) {
            if (vowel.contains(words[i].charAt(0))) {
                sb.append(words[i] + "ma");
            } else {
                char firstLetter = words[i].charAt(0);
                sb.append(words[i].substring(1, words[i].length()));
                sb.append(firstLetter + "ma");
            }

            // #3 add the "a"
            for (int j = 0; j < i + 1; j++) {
                sb.append("a");
            }
            sb.append(" ");
        }

        // System.out.println(sb.toString());

        return sb.toString().trim();
    }

    // online best solutin
    public String toGoatLatinRef(String S) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        String res = "";
        int i = 0, j = 0;

        for (String w : S.split("\\s")) {
            res += ' ' + (vowels.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)) + "ma";
            for (j = 0, ++i; j < i; ++j) {
                res += "a";
            }
        }

        return res.substring(1);
    }

    public static void main(String[] args) {
        GoatLatin sol = new GoatLatin();
        assert sol.toGoatLatin("I speak Goat Latin").equals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa") : "T1 Failed";
        assert sol.toGoatLatin("The quick brown fox jumped over the lazy dog").equals(
                "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa")
                : "T1 Failed";
    }
}
