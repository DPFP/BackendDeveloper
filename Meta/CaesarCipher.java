import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // String str = in.nextLine();
        // int length = str.length();
        // int k = Integer.parseInt(in.nextLine());
        // k = k % 26;

        // System.out.println(encrypt(str, length, k));
        // in.close();
        String test = "Zebra-493?";

        System.out.println(rotationalCipher(test, 3));
        System.out.println(rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39));
    }

    private static String encrypt(String str, int length, int shift) {
        StringBuilder strBuilder = new StringBuilder();

        char c;

        for (int i = 0; i < length; i++) {
            c = str.charAt(i);
            // if c is letter ONLY then shift them, else directly add it
            if (Character.isLetter(c)) {
                c = (char) (str.charAt(i) + shift);
                // System.out.println(c);

                // checking case or range check is important, just if (c > 'z'
                // || c > 'Z')
                // will not work
                if ((Character.isLowerCase(str.charAt(i)) && c > 'z')
                        || (Character.isUpperCase(str.charAt(i)) && c > 'Z'))

                    c = (char) (str.charAt(i) - (26 - shift));
            }
            strBuilder.append(c);
        }
        return strBuilder.toString();
    }

    // 1st version
    private static String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        char c;

        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (Character.isAlphabetic(c)) { // vs. isLetter
                // Character.isLetter(c);
                int rotate = rotationFactor % 26;

                c = (char) (input.charAt(i) + rotate);

                if ((Character.isLowerCase(input.charAt(i)) && c > 'z')
                        || (Character.isUpperCase(input.charAt(i)) && c > 'Z')) {
                    c = (char) (input.charAt(i) - (26 - rotate));
                }

            } else if (Character.isDigit(c)) {
                // rotationFactor = rotationFactor % 10;
                int val = Character.getNumericValue(input.charAt(i)) + rotationFactor;
                c = (char) ((val) % 10 + 48);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    // cleaner version
    String rotationalCipher2(String input, int rotationFactor) {
        // Write your code here
        StringBuilder sb = new StringBuilder();

        // have to have this, you don't want to change the char within input;
        char c;

        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);

            if (Character.isAlphabetic(c)) { // vs. Character.isLetter(c);
                if (Character.isLowerCase(input.charAt(i))) {
                    c = (char) ((c - 'a' + rotationFactor) % 26 + 'a');
                }
                if (Character.isUpperCase(input.charAt(i))) {
                    c = (char) ((c - 'A' + rotationFactor) % 26 + 'A');
                }
            } else if (Character.isDigit(c)) {
                c = (char) (((c - '0' + rotationFactor) % 10) + '0');
            }
            sb.append(c);
        }

        return sb.toString();
    }
}