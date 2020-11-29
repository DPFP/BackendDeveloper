import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {

        // can't handle punctuation
        // StringTokenizer t = new StringTokenizer(paragraph);

        // use map -- better choice is use MaxHeap
        Map<String, Integer> count = new HashMap<>();

        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(paragraph.toLowerCase());

        while (m.find()) {
            count.put(m.group(), count.getOrDefault(m.group(), 0) + 1);
            // System.out.println(m.group());
        }

        int max = 0;
        String word = "";
        List<String> bannedList = Arrays.asList(banned);

        for (String s : count.keySet()) {
            if (count.get(s) > max && !bannedList.contains(s)) {
                max = count.get(s);
                word = s;
            }
            // System.out.println(s + ": " + count.get(s));
        }

        // System.out.println(word);

        return word;
    }

    public static void main(String[] args) {
        MostCommonWord sol = new MostCommonWord();
        String[] banned = { "hello" };
        assert sol.mostCommonWord("hello, hello! hello!! world,  doudou doudou", banned).equalsIgnoreCase("doudou")
                : "T1 Failed";

        String t2 = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] b2 = { "hit" };
        assert sol.mostCommonWord(t2, b2).equalsIgnoreCase("ball") : "T2 failed";
    }
}
