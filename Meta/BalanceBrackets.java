import java.util.Stack;

public class BalanceBrackets {
    boolean isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
        }
        // { [ ( -- ) ] }
        // stack:
        return stack.isEmpty();
    }
}
