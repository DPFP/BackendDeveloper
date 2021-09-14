import java.util.*;

public class Sept14thReverseOnlyLetter {

    // 917. Reverse Only Letters

    public String reverseOnlyLetters(String s) {
        Stack<Character> input = new Stack<>();

        int index = 0;
        Map<Integer, Character> other = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                input.push(c);
            } else {
                other.put(index, c);
            }
            index++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (other.keySet().contains(i)) {
                sb.append(other.get(i));
            } else {
                sb.append(input.pop());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Sept14thReverseOnlyLetter sol = new Sept14thReverseOnlyLetter();
        System.out.println(sol.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
