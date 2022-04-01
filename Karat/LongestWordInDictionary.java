import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {

    // 720. Longest Word in Dictionary
    // best solution:
    // https://leetcode.com/problems/longest-word-in-dictionary/discuss/109114/JavaC%2B%2B-Clean-Code
    public String longestWord(String[] words) {
        Arrays.sort(words); // sort aplha order shortest --> longest
        Set<String> built = new HashSet<>();
        String res = "";

        for (String word : words) {
            if (word.length() == 1 || built.contains(word.substring(0, word.length() - 1))) {
                res = word.length() > res.length() ? word : res;
                built.add(word);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String w = "HelloWorld";
        String e = "";
        System.out.println(w.substring(0, w.length() - 1)); // [inclusive,exclusive)
        System.out.println(e.length()); // 0
    }
}