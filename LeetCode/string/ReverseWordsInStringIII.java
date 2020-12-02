public class ReverseWordsInStringIII {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        // #1 get list of words
        String[] words = s.split(" ");

        // #2 reverse each word
        for (int i = 0; i < words.length; i++) {
            sb.setLength(0);
            words[i] = sb.append(words[i]).reverse().toString();
            // System.out.println(words[i]);
        }
        // #3 append space in between
        sb.setLength(0);
        for(String w : words){
            sb.append(w + " ");
        }

        // System.out.println(sb.toString().trim());

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWordsInStringIII sol = new ReverseWordsInStringIII();
        assert sol.reverseWords("Let's take LeetCode contest").equalsIgnoreCase("s'teL ekat edoCteeL tsetnoc") : "T1 Failed";
    }
}
