public class ReverseInteger {
    public int reverse(int x) {
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

    public static void main(String[] args) {
        ReverseInteger sol = new ReverseInteger();
        assert sol.reverse(0) == 0 : "Failed 100";
        assert sol.reverse(2147483647) == 0 : "Failed 2147483647 ";
        assert sol.reverse(-2147483647) == 0 : "Failed -2147483647";
        assert sol.reverse(100) == 1 : "Failed 100";
        assert sol.reverse(123) == 321 : "Failed 123";
        assert sol.reverse(-123) == -321 : "Failed -123";
        assert sol.reverse(120) == 21 : "Failed 123";
    }
}
