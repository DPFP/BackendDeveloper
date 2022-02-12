package JavaBasic;

public class StringManipulation {
    public static void main(String[] args) {
        String s = "abcde";
        String s2 = "efgh";
        checkString(s);
        checkString(s2);

        // index of return the first find element;
        System.out.println("Index: of o " + "facebook".indexOf("o"));
    }

    private static void checkString(String s) {
        int len = s.length();
        System.out.println("check String:" + s + " length:" + len);

        System.out.println(len / 2); // 5/2 --> 2

        // subString is [)
        System.out.println(s.substring(0, len / 2)); // index [0-2) --> 0,1
        System.out.println(s.charAt(len / 2)); // index 5/2 = 2 --> 2
        System.out.println(s.substring(len / 2 + 1, len)); // index [3-5) --> 3,4
    }
}
