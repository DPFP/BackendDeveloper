
public class AddBinary {

    // refer to solution
    public String addBinarySol(String a, String b) {
        // 1 <= a.length, b.length <= 104
        if (a.isBlank() || b.isBlank()) {
            return null;
        }

        // #1 This not gonna work, because overflow
        // return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b,
        // 2));

        // #2 This not gonna work, because overflow
        // long aValue = Long.parseLong(a, 2);
        // long bValue = Long.parseLong(b, 2);
        // long total = aValue + bValue;
        // System.out.println(aValue + " " + bValue + " " + total);
        // return Long.toBinaryString(total);

        // #3 Have to create a separate method for bit manupulation
        // Two methods String binary --> Number(float/double) --> Sting binary

        // #4 One method to Merge a & b --> result
        if (a.length() > b.length()) {
            return merge(a, b);
        } else {
            return merge(b, a);
        }
    }

    private String merge(String l, String s) {
        StringBuilder sb = new StringBuilder();

        // append 0
        for (int i = 0; i < l.length() - s.length(); i++) {
            sb.append("0");
        }
        s = sb.append(s).toString();

        // clear sb
        sb.setLength(0);

        // loop through
        int carry = 0;
        int num1;
        int num2;
        for (int i = l.length() - 1; i >= 0; i--) {
            // System.out.println(Character.toString(l.charAt(i) & s.charAt(i)));
            num1 = l.charAt(i) - '0';
            num2 = s.charAt(i) - '0';

            if (carry + num1 + num2 > 1) {
                sb.append(carry + num1 + num2 - 2);
                carry = 1;
            } else {
                sb.append(carry + num1 + num2);
                carry = 0;
            }
        }

        if (carry == 1) {
            sb.append(1);
        }

        System.out.println("l:" + l);
        System.out.println("s:" + s);

        return sb.reverse().toString();
    }

    // 2nd try
    // Given two binary strings a and b, return their sum as a binary string.
    // 1 <= a.length, b.length <= 104
    public String addBinary(String a, String b) {
        String result = "";

        // #1, starting from right.

        // #2, if 1 & 1 --> carryOver = 1, remain = 0
        // #3, how to handle carryover addition ?

        return result;
    }

    public static void main(String[] args) {
        AddBinary sol = new AddBinary();

        String t1 = "1";
        String t2 = "0";
        String t3 = "11";
        String t4 = "10";
        String t5 = "1011";
        String t6 = "1010";
        String t31 = "1101";

        String t7 = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String t8 = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

        assert sol.addBinary(t1, t2).equalsIgnoreCase("1") : "T1 failed";
        assert sol.addBinary(t1, t3).equalsIgnoreCase("100") : "T2 failed";
        assert sol.addBinary(t2, t3).equalsIgnoreCase("11") : "T3 failed";
        assert sol.addBinary(t3, t4).equalsIgnoreCase("101") : "T4 failed";
        assert sol.addBinary(t5, t6).equalsIgnoreCase("10101") : "T5 failed";
        // assert sol.addBinary(t7, t8).equalsIgnoreCase("10101") : "T6 failed";
        assert sol.addBinary(t3, t31).equalsIgnoreCase("10000") : "T7 failed";

    }

}
