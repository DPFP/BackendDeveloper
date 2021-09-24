import java.util.Stack;

public class Sept23thBreakPalindrome {
    public String breakPalindromeFirstTry(String palindrome) {
        if (palindrome.length() < 2) {
            return "";
        }

        int index = 0;
        for (char c : palindrome.toCharArray()) {
            if (c != 'a') {
                break;
            }
            index++;
        }

        if (index == palindrome.length()) {
            return palindrome.substring(0, index - 1) + 'b';
        }

        return palindrome.substring(0, index) + 'a' + palindrome.substring(index + 1);

    }

    public String breakPalindrome(String palindrome) {
        // https://helloacm.com/how-to-break-a-palindrome-string-by-replacing-a-character/
        if (palindrome.length() == 1)
            return "";
        for (int i = 0; i < palindrome.length() / 2; ++i) {
            if (palindrome.charAt(i) != 'a') {
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1);
            }
        }
        return palindrome.substring(0, palindrome.length() - 1) + 'b';
    }

    public boolean isPalindrome(String input) {
        boolean result = false;
        Stack<Character> check = new Stack<>();
        if (input.length() % 2 == 0) {
            // even length
            // 0,1,2 == 5,4,3
            for (int i = 0; i < input.length() / 2; i++) {
                check.push(input.toCharArray()[i]);
            }

            for (int i = input.length() / 2; i < input.length(); i++) {
                if (check.pop() == input.toCharArray()[i]) {
                    result = true;
                } else {
                    return false;
                }
            }
            return result;
        } else {
            // odd length
            for (int i = 0; i < input.length() / 2; i++) {
                check.push(input.toCharArray()[i]);
            }

            for (int i = input.length() / 2 + 1; i < input.length(); i++) {
                if (check.pop() == input.toCharArray()[i]) {
                    result = true;
                } else {
                    return false;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Sept23thBreakPalindrome sol = new Sept23thBreakPalindrome();
        System.out.println(sol.isPalindrome("abba"));
        System.out.println(sol.isPalindrome("abab"));
        System.out.println(sol.isPalindrome("abcba"));
        System.out.println(sol.isPalindrome("abcca"));

        System.out.println(sol.breakPalindrome("aba"));
        System.out.println(sol.breakPalindrome("aaa"));
        System.out.println(sol.breakPalindrome("aa"));
    }
}
