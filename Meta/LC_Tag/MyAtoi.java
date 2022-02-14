package Meta.LC_Tag;

public class MyAtoi {

    // my previous appraoch
    public int myAtoi(String s) {
        if (s.isEmpty() || s.trim().isEmpty()) {
            return 0;
        } else {
            s = s.stripLeading();
        }

        // trim lending white space

        // 0 ~ 9 --> 48 ~ 57
        // + --> 43, - --> 45, . --> 46

        int index = 0;
        int length = 0;

        boolean negative = false;
        int[] digits = new int[s.length()];

        while (index < s.length()) {
            if (s.charAt(index) <= 57 && s.charAt(index) >= 48) {
                // 0 ?
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

    // LC official sotlution
    public int myAtoi2(String input) {
        int sign = 1;
        int result = 0;

        int index = 0; // use one pointer to go through the string O(N) time. O(1) space
        int n = input.length();

        // ignore any leading space;
        while (index < n && input.charAt(index) == ' ') {
            index++;
        }

        // grab the sign;
        if (index < n && input.charAt(index) == '+') {
            // sign = 1;
            index++;
        } else if (index < n && input.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        // traverse through remaining char
        // C: great use of Character.isDigit here
        while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0'; // dont fogert minus '0' to get the actual number;

            // check overflow and underflow conditions
            // C: this is the critical part to check the edge cases
            // 2147483647/10 = 214748364 < 214748365 (if 214748365 * 10 --> always overlow )
            if ((result > Integer.MAX_VALUE / 10)
                    || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) { // very tricky to think
                // 2147483647/10 = 214748364 (if digt > 7, will be a problem);
                // 2^31 - 1, or -2^31
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = 10 * result + digit; // this is how to increment the value
            index++;
        }

        return sign * result;
    }

    public static void main(String[] args) {
        MyAtoi sol = new MyAtoi();
        System.out.println(sol.myAtoi2("   -42"));

        System.out.println(Integer.MAX_VALUE); // 2_147_483_647 -- 2 billion 2^31 - 1 (32-bit)
        System.out.println(Integer.MAX_VALUE / 10); // 214748364
        System.out.println(Integer.MIN_VALUE); // -2147483648 -- -2 billion -2^31 (32-bit)
    }
}
