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

    // second approach mimic online solution
    public int myAtoi(String s) {

        // #1 trim leading whitespace
        if (s.isEmpty() || s.trim().isEmpty()) {
            return 0;
        } else {
            s = s.stripLeading();
        }

        int sign = 1, start = 0, len = s.length();
        long sum = 0;

        // #2 +, - &
        if (s.charAt(0) == 45) { // -
            sign = -1;
            start++;
        } else if (s.charAt(0) == 43) { // +
            sign = 1;
            start++;
        }

        for (int i = start; i < len; i++) {
            // check if next number still an number
            if (!Character.isDigit(s.charAt(i))) {
                return (int) sum * sign;
            }
            // key step on shift the number to left
            sum = sum * 10 + s.charAt(i) - '0';

            // capture edge case
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) sum * sign;
    }

    // online solution
    public int atoi(String str) {

        if (str == null || str.length() == 0)
            return 0;//

        str = str.trim();

        char firstChar = str.charAt(0);

        int sign = 1, start = 0, len = str.length();
        long sum = 0;

        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) sum * sign;
            }
            // key step on shift the number to left
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) sum * sign;
    }

    public static void main(String[] args) {
        String t1 = "42";
        String t2 = "-42";

        Atoi sol = new Atoi();

        System.out.println(Integer.MAX_VALUE);
        System.out.println();
        System.out.println(Integer.MIN_VALUE);

        assert sol.myAtoi(t1) == 42 : "T1 faield";
        assert sol.myAtoi(t2) == -42 : "T2 faield";
        assert sol.myAtoi("4193 with words") == 4193 : "T3 faield";
        assert sol.myAtoi("words and 987") == 0 : "T4 faield";
        assert sol.myAtoi("-91283472332") == -2147483648 : "T5 faield";
        assert sol.myAtoi("91283472332") == 2147483647 : "T6 faield";
        assert sol.myAtoi("-+12") == 0 : "T7 faield";
        assert sol.myAtoi("+1") == 1 : "T8 faield";
        assert sol.myAtoi("1+1") == 1 : "T9 faield";
        assert sol.myAtoi("-2147483647") == -2147483647 : "T10 faield: ";

    }
}
