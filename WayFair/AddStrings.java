public class AddStrings {

    // 415. Add Strings
    // https://leetcode.com/problems/add-strings/

    // LC official solution -- most precise solution
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;

        int cc = 0;

        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;

            int sum = x1 + x2 + carry;
            sb.append(sum % 10); // digit (reverse order)
            carry = (sum) / 10; // carry for next round

            p1--;
            p2--;
            cc++;

            // 1 000000 -- 7
            // 1 000,000 -- 8 (carry)
            // 1 ,000,000 -- 9
            if (cc == 3 && !(p1 <= 0 && p2 <= 0)) {
                sb.append(",");
                cc = 0;
            }
        }

        if (carry != 0) {
            sb.append(',');
            sb.append(carry);
        }
        System.out.println(sb.toString() + " - " + sb.reverse().toString());

        // added the fromat comma --> this still require convert to integer!
        // System.out.println(String.format("%,d",
        // Integer.parseInt(sb.reverse().toString())));

        return sb.toString();
    }

    public static void main(String[] args) {
        AddStrings sol = new AddStrings();

        sol.addStrings("101", "202000");
        sol.addStrings("111", "222222");
        sol.addStrings("922222", "222222");
        sol.addStrings("1", "999");
        sol.addStrings("1", "999999");
        sol.addStrings("1", "9999999");
        sol.addStrings("1", "99999999");
        sol.addStrings("1", "999999999");

        assert sol.addStrings("101", "202000").equalsIgnoreCase("202101") : "T1 Failed";
        assert sol.addStrings("111", "222").equalsIgnoreCase("333") : "T2 Failed";
        assert sol.addStrings("111", "222222").equalsIgnoreCase("222333") : "T3 Failed";
        assert sol.addStrings("111", "999").equalsIgnoreCase("1110") : "T4 Failed";

        assert sol.addStrings("1", "999").equalsIgnoreCase("1000") : "T5 Failed";
        assert sol.addStrings("1", "999999").equalsIgnoreCase("1000000") : "T5 Failed";
    }
}
