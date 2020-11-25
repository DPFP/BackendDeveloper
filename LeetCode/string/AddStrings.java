public class AddStrings {

    // You must not use any built-in BigInteger library or convert the inputs to
    // integer directly.
    public String addStrings(String num1, String num2) {
        // append the leading zero
        if (num1.length() > num2.length()) {
            num2 = appendZero(num2, num1.length() - num2.length());
        } else {
            num1 = appendZero(num1, num2.length() - num1.length());
        }

        // System.out.println(num1);
        // System.out.println(num2);

        StringBuilder sb = new StringBuilder();
        int remainder = 0;
        int a, b = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {

            a = Character.getNumericValue(num1.charAt(i));
            b = Character.getNumericValue(num2.charAt(i));

            if (a + b + remainder > 9) {
                sb.append(a + b + remainder - 10);
                remainder = 1;
            } else {
                sb.append(a + b + remainder);
                remainder = 0;
            }
        }
        if (remainder > 0) {
            sb.append(remainder);
        }
        sb.reverse();

        // System.out.println(sb.toString());

        return sb.toString();
    }

    private String appendZero(String input, int numOfZero) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numOfZero; i++) {
            sb.append("0");
        }
        sb.append(input);

        return sb.toString();
    }

    public static void main(String[] args) {
        AddStrings sol = new AddStrings();

        assert sol.addStrings("101", "202000").equalsIgnoreCase("202101") : "T1 Failed";
        assert sol.addStrings("111", "222").equalsIgnoreCase("333") : "T2 Failed";
        assert sol.addStrings("111", "222222").equalsIgnoreCase("222333") : "T3 Failed";
        assert sol.addStrings("111", "999").equalsIgnoreCase("1110") : "T4 Failed";
    }
}
