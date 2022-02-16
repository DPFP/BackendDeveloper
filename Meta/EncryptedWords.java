public class EncryptedWords {
    private static String findEncryptedWord(String s) {
        // Write your code here
        // R "[middle/left-most] [encrypted-left-] [encrypted-right-]"
        // abc --> b a c
        if (s == null || s.length() <= 1) {
            return s;
        }

        // split string into three parts: left, middle, right --> append together
        int len = s.length();

        String left, right;
        String middle;
        if (len % 2 == 1) {
            // left = s.substring(0,len/2);
            middle = Character.toString(s.charAt(len / 2));
            // right = s.substring((len/2)+1,len);
        } else {
            // left = s.substring(0,(len/2)-1);
            middle = Character.toString(s.charAt((len / 2) - 1));
            // right = s.substring((len/2)+1,len);
        }
        // "facebook" won't work with split, because "oo" is duplicated.
        // String[] strs = s.split(middle);
        int index = s.indexOf(middle);

        left = findEncryptedWord(s.substring(0, index));
        right = findEncryptedWord(s.substring(index + 1, len));

        return middle + left + right;
    }

    public static void main(String[] args) {
        String t1 = "abc";
        String t2 = "abcd";
        String t3 = "abcxcba";
        String t4 = "facebook";
        // System.out.println(findEncryptedWord(t2));
        // System.out.println(findEncryptedWord(t3));
        System.out.println(findEncryptedWord(t4));

    }
}
