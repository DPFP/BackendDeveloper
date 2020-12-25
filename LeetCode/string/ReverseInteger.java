public class ReverseInteger {

    // brute force
    public int reverseBF(int x) {
        if (x == 0) {
            return 0;
        }

        boolean negative = false;
        String xString = Integer.toString(x);

        if (xString.charAt(0) == 45) {
            negative = true;
            xString = xString.substring(1, xString.length());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = xString.length() - 1; i >= 0; i--) {
            sb.append(xString.charAt(i));
        }

        Integer result = 0;
        try {
            result = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }

        if (negative) {
            result = result * (-1);
        }

        return result;
    }

    // 2nd try
    public int reverse(int x) {
        int result = 0, sign = 1;
        long reversed = 0L;

        if (x < 0) {
            sign = -1;
        }

        // #1 if it single digit return;
        if (x < 10 && x > -10) {
            return x;
        }

        String xs = Integer.toString(x);
        if (sign == -1) {
            xs = xs.substring(1, xs.length());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = xs.length() - 1; i >= 0; i--) {
            sb.append(xs.charAt(i));
        }
        reversed = Long.parseLong(sb.toString());

        // #2 if reversed number it larger than Integer.MAX
        if (reversed > Integer.MAX_VALUE) {
            return 0;
        }
        // #3 if reversed number it within Integer.MAX
        result = (int) reversed;
        return result * sign;
    }

    public static void main(String[] args) {
        ReverseInteger sol = new ReverseInteger();

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        assert sol.reverse(-2147483648) == 0 : "Failed 0";
        assert sol.reverse(0) == 0 : "Failed 0";
        assert sol.reverse(2147483647) == 0 : "Failed 2147483647 ";
        assert sol.reverse(-2147483647) == 0 : "Failed -2147483647";
        assert sol.reverse(100) == 1 : "Failed 100";
        assert sol.reverse(123) == 321 : "Failed 123";
        assert sol.reverse(-123) == -321 : "Failed -123";
        assert sol.reverse(120) == 21 : "Failed 123";
    }
}
