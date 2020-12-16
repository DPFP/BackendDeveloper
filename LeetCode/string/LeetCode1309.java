public class LeetCode1309 {
    // Decrypt String from Alphabet to Integer Mapping

    // a b c d e f g h i --> 1 ~ 9
    // j k l m n o p q r .. z --> 10# ~ 26#

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (index < s.length()) {
            if (index + 2 < s.length() && s.charAt(index) == '1' && s.charAt(index + 2) == '#') {
                // 1 or 1 0~9 #
                // System.out.println(Character.toChars(s.charAt(index) + s.charAt(index + 1) +
                // 9));
                sb.append(Character.toChars(s.charAt(index) + s.charAt(index + 1) + 9));
                index += 3;
            } else if (index + 2 < s.length() && s.charAt(index) == '2' && s.charAt(index + 2) == '#') {
                // 2 or 2 0~6 #
                // System.out.println(Character.toChars(s.charAt(index) + s.charAt(index + 1) +
                // 18));
                sb.append(Character.toChars(s.charAt(index) + s.charAt(index + 1) + 18));
                index += 3;
            } else {
                // 3 4 5 6 7 8 9
                // System.out.println(Character.toChars(s.charAt(index) + 48));
                sb.append(Character.toChars(s.charAt(index) + 48));
                index++;
            }
        }
        System.out.println(sb.toString());

        return sb.toString();
    }

    // onlinesolution
    public String freqAlphabetsOS(String s) {
        StringBuilder sb = new StringBuilder();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (i + 2 < size && s.charAt(i + 2) == '#') {
                sb.append((char) ((Integer.parseInt(s.substring(i, i + 2)) - 1) + 'a'));
                i = i + 2;
            } else
                sb.append((char) ((Integer.parseInt(String.valueOf(s.charAt(i))) - 1) + 'a'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1309 sol = new LeetCode1309();

        assert sol.freqAlphabets("10#26#23").equals("jzbc") : "T1 Failed";
        assert sol.freqAlphabets("10#11#12").equals("jkab") : "T2 Failed";
        assert sol.freqAlphabets("1326#").equals("acz") : "T3 Failed";
        assert sol.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#")
                .equals("abcdefghijklmnopqrstuvwxyz") : "T4 Failed";

    }
}
