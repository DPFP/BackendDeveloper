public class ReverseWordsInString {

    public String reverseWords(String s) {
        if (s.isBlank()) {
            return s;
        }

        s = s.strip();
        s = s.replaceAll("\\s{2,}", " ");

        String[] inputArray = s.split(" ");

        s = "";
        for (int i = inputArray.length - 1; i >= 0; i--) {
            s += inputArray[i] + " ";
        }
        // System.out.println(s);
        return s.trim();
    }

    // cleaner version
    public String reverseWords2(String s) {
        s = s.strip().replaceAll("\\s{2,}", " ");
        String[] words = s.split(" ");

        s = "";
        for (int i = words.length - 1; i >= 0; i--) {
            s += words[i] + " ";
        }

        return s.trim();
    }

    // TODO reduce memeory usage (not using String array)

    public static void main(String[] args) {
        ReverseWordsInString sol = new ReverseWordsInString();
        String t1 = "   the sky is blue";
        String t2 = "  hello world  ";
        String t3 = "a good   example";
        String t4 = "  Bob    Loves  Alice   ";

        assert sol.reverseWords2(t1).equalsIgnoreCase("blue is sky the") : "T1 Failed";
        assert sol.reverseWords2(t2).equalsIgnoreCase("world hello") : "T2 Failed";
        assert sol.reverseWords2(t3).equalsIgnoreCase("example good a") : "T3 Failed";
        assert sol.reverseWords2(t4).equalsIgnoreCase("Alice Loves Bob") : "T4 Failed";
    }
}
