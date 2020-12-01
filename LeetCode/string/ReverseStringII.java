public class ReverseStringII {

    // Given a string and an integer k, you need to reverse the first k characters
    // for every 2k characters counting from the start of the string. If there are
    // less than k characters left, reverse all of them. If there are less than 2k
    // but greater than or equal to k characters, then reverse the first k
    // characters and left the other as original.

    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (s.trim().length() > 0) {
            if (s.length() >= 2 * k) {
                sb2.setLength(0);
                sb.append(sb2.append(s.substring(0, k).toCharArray()).reverse().toString());
                sb.append(s.substring(k, 2 * k));
                s = s.substring(2 * k, s.length());
            } else if (s.length() >= k && s.length() < 2 * k) {
                sb2.setLength(0);
                sb.append(sb2.append(s.substring(0, k).toCharArray()).reverse().toString());
                sb.append(s.substring(k, s.length()));
                s = "";
            } else {
                sb2.setLength(0);
                sb.append(sb2.append(s.substring(0, s.length()).toCharArray()).reverse().toString());
                s = "";
            }
        }
        System.out.println(sb.toString());

        return sb.toString();
    }

    public String reverseString(char[] s) {
        char temp;
        for (int i = 0; i < s.length / 2; i++) {
            temp = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = temp;
        }
        System.out.println(s.toString());
        return s.toString();
    }

    public static void main(String[] args) {
        ReverseStringII sol = new ReverseStringII();
        assert sol.reverseStr("abcdefg", 2).equalsIgnoreCase("bacdfeg") : "T1 Failed";
        assert sol.reverseStr("abcd", 2).equalsIgnoreCase("bacd") : "T2 Failed";
    }
}
