public class Sept8th {

    public String shiftingLettersCopilot(String s, int[] shifts) {
        int len = s.length();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (s.charAt(i) - 'a' + shifts[i]) % 26;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append((char) ('a' + (arr[i] + shifts[i]) % 26));
        }

        return sb.toString();

        // StringBuilder sb = new StringBuilder();
        // // shift 1
        // for (int shift : shifts) {
        // sb.setLength(0);
        // for (int i = 0; i < len; i++) {
        // int ct = Character.getNumericValue(s.charAt(i)) + (shift % 26) + '0';
        // char c = (char) (ct + '0');
        // System.out.println(c);
        // sb.append(c);
        // // System.out.println((char) (ct + '0'));
        // }
        // s = sb.toString();
        // }

        // return s;
    }

    public String shiftingLetters(String S, int[] shifts) {
        char[] arr = S.toCharArray();
        int shift = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            shift = (shift + shifts[i]) % 26;
            arr[i] = (char) ((arr[i] - 'a' + shift) % 26 + 'a');
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Sept8th sept8th = new Sept8th();
        System.out.println(sept8th.shiftingLetters("abc", new int[] { 3, 5, 9 }));

        int c = (Character.getNumericValue('a') + 1 % 26);
        // System.out.println((char) (c));
        // System.out.println(Character.forDigit(c, 16));
        // System.out.println(Character.getNumericValue('a'));
        // System.out.println(Character.getNumericValue('A'));
    }
}
