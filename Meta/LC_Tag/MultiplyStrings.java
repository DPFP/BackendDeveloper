package Meta.LC_Tag;

public class MultiplyStrings {

    // 43. Multiply Strings
    // https://leetcode.com/problems/multiply-strings/

    // Online solution
    // https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
    // https://labuladong.gitee.io/algo/4/32/135/
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        // e.g. for 123 * 45
        // [0,1,2,3,4]
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                // TODO: Here is the Key !!!
                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + pos[p2]; // 15 + 0 = 15 --> 进位 carry Over

                pos[p1] += sum / 10;
                pos[p2] = sum % 10; // carry-over 进位
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            // ignore all the leading zeros !
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings sol = new MultiplyStrings();
        System.out.println(sol.multiply("100", "100"));

    }
}
