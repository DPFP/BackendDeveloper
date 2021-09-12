import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Sept11th {

    public int calculateSelf(String s) {
        int res = 0;

        String[] in = s.trim().split("-|\\+|\\(|\\)"); // split by - or split by + or split by ( or split by )
        Queue<String> nums = new LinkedList<>();

        char[] input = s.toCharArray();
        Queue<Character> operator = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : input) { // numbers
            if (c != '+' && c != '-' && c != ' ' && c != '(' && c != ')') {
                operator.add(c);
            } else {
                sb.setLength(0);
                while (!operator.isEmpty()) {
                    sb.append(operator.remove());
                }
                // add operator
                nums.add(sb.toString());

                // add the symbol
                if (c == '+' && c == '-') {
                    nums.add(Character.toString(c));
                }
            }
        }

        while (!nums.isEmpty()) {
            String c = nums.remove(); // 1
            if (c.equals("+")) {
                String d = nums.remove();
                res = res + Integer.parseInt(d);
            } else if (c.equals("-")) {
                String d = nums.remove();
                res = res - Integer.parseInt(d);
            } else {
                res = res + Integer.parseInt(c); // int a = ch - '0';
            }
        }

        return res;
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int) (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                // we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                // reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // stack.pop() is the sign before the parenthesis
                result += stack.pop(); // stack.pop() now is the result calculated before the parenthesis

            }
        }
        if (number != 0)
            result += sign * number;
        return result;
    }

    public static void main(String[] args) {
        Sept11th sol = new Sept11th();
        String t1 = "1 + 1";
        String t2 = " 2-1 + 2 ";
        String t3 = "(1+(4+5+2)-3)+(6+8)";
        String t4 = "2147483647";
        String t5 = "12 + 34";
        // System.out.println(sol.calculate(t1));
        // System.out.println(sol.calculate(t2));
        // System.out.println(sol.calculate(t3));
        // System.out.println(Integer.MAX_VALUE);
        // System.out.println(Integer.MIN_VALUE);
        System.out.println(sol.calculate(t5));
        String[] input = t4.trim().split("-|\\+|\\(|\\)");
        for (String s : input) {
            // System.out.println(s);
        }
    }
}
