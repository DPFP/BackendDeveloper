public class Atoi {
    // https://leetcode.com/problems/string-to-integer-atoi/

    // First BF approach
    public int myAtoiBF(String s) {
        if (s.isEmpty() || s.trim().isEmpty()) {
            return 0;
        } else {
            // trim lending white space
            s = s.stripLeading();
        }

        // 0 ~ 9 --> 48 ~ 57
        // + --> 43, - --> 45, . --> 46

        int index = 0;
        int length = 0;
        boolean negative = false;
        int[] digits = new int[s.length()];

        while (index < s.length()) {
            if (s.charAt(index) <= 57 && s.charAt(index) >= 48) {
                digits[length] = Character.getNumericValue(s.charAt(index));
                length++;
            } else if (s.charAt(index) == 45 && index == 0) {
                negative = true;
            } else if (s.charAt(index) == 43 && index == 0) {
                negative = false;
            } else {
                break;
            }
            index++;
        }

        double result = 0.0;
        for (int i = 0; i < length; i++) {
            result = result + digits[i] * Math.pow(10, (length - i - 1));
        }

        if (result - Integer.MAX_VALUE > 0) {
            result = Integer.MAX_VALUE;
            if (negative) {
                result++;
            }
        }

        if (negative) {
            result = result * (-1);
        }

        return (int) result;
    }

    // second approach
    public int myAtoi(String s) {

        return 0;
    }

    public static void main(String[] args) {
        String t1 = "42";
        String t2 = "-42";
        String t3 = "4193 with words";
        String t4 = "words and 987";
        String t5 = "-91283472332";
        String t6 = "91283472332";
        String t7 = "-+12"; // 0
        String t8 = "+1"; // 1
        String t9 = "1+1"; // 1
        String t10 = "-2147483647";

        Atoi sol = new Atoi();

        System.out.println(Integer.MAX_VALUE);
        System.out.println();
        System.out.println(Integer.MIN_VALUE);

        assert sol.myAtoi(t1) == 42 : "T1 faield";
        assert sol.myAtoi(t2) == -42 : "T2 faield";
        assert sol.myAtoi(t3) == 4193 : "T3 faield";
        assert sol.myAtoi(t4) == 0 : "T4 faield";
        assert sol.myAtoi(t5) == -2147483648 : "T5 faield";
        assert sol.myAtoi(t6) == 2147483647 : "T6 faield";
        assert sol.myAtoi(t7) == 0 : "T7 faield";
        assert sol.myAtoi(t8) == 1 : "T8 faield";
        assert sol.myAtoi(t9) == 1 : "T9 faield";
        assert sol.myAtoi(t10) == -2147483647 : "T10 faield: " + sol.myAtoi(t10);

    }
}
