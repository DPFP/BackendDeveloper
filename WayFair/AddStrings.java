import java.util.HashMap;
import java.util.Map;

public class AddStrings {

    // 415. Add Strings
    // https://leetcode.com/problems/add-strings/

    // LC official solution -- most precise solution
    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;

        num1 = num1.replace(",", "");
        num2 = num2.replace(",", "");

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
        sb.reverse();

        // System.out.println(sb.toString() + " - " + sb.toString());

        // added the fromat comma --> this still require convert to integer!
        // System.out.println(String.format("%,d", Integer.parseInt(sb.toString())));

        return sb.toString();
    }

    private Map<Integer, String> fibMap = new HashMap<>();

    private String getFib(int n) {
        if (n == 1) {
            return "0";
        }

        if (n < 4) {
            return "1";
        }

        if (fibMap.get(n) != null) {
            return fibMap.get(n);
        } else {
            fibMap.put(n, addStrings(getFib(n - 2), getFib(n - 1)));
        }

        return fibMap.get(n);
    }

    public static void main(String[] args) {
        AddStrings sol = new AddStrings();

        System.out.println(sol.getFib(19));

        sol.addStrings("101", "202,000");
        sol.addStrings("111", "222,222");
        sol.addStrings("922222", "222,222");
        sol.addStrings("1", "999");
        sol.addStrings("1", "999,999");
        sol.addStrings("1", "9,999,999");
        sol.addStrings("1", "99,999,999");
        sol.addStrings("1", "999,999,999");

        assert sol.addStrings("101", "202000").equalsIgnoreCase("202101") : "T1 Failed";
        assert sol.addStrings("111", "222").equalsIgnoreCase("333") : "T2 Failed";
        assert sol.addStrings("111", "222222").equalsIgnoreCase("222333") : "T3 Failed";
        assert sol.addStrings("111", "999").equalsIgnoreCase("1110") : "T4 Failed";

        assert sol.addStrings("1", "999").equalsIgnoreCase("1000") : "T5 Failed";
        assert sol.addStrings("1", "999999").equalsIgnoreCase("1000000") : "T5 Failed";
    }
}
