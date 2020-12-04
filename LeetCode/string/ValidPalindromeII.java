public class ValidPalindromeII {

    // Brute force solution -- Time Limit Exceeded
    public boolean validPalindromeBruteFore(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);

        if (sb.toString().equalsIgnoreCase(sb.reverse().toString())) {
            return true;
        } else {
            for (int i = 0; i < s.length(); i++) {
                sb.setLength(0);
                sb.append(s);
                sb.deleteCharAt(i);
                if (sb.toString().equalsIgnoreCase(sb.reverse().toString())) {
                    return true;
                }
                // sb.insert(i, 'a');
            }
        }
        return false;
    }

    // refer to solution (LeetCode solution is confusing as heck)
    // better explain
    // https://www.geeksforgeeks.org/remove-character-string-make-palindrome/
    public boolean isPalindromeRange(String s, int l, int r) {
        // this can be change to while loop
        for (int k = l; k <= l + (r - l) / 2; k++) {
            if (s.charAt(k) != s.charAt(r - k + l))
                return false;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            // move cloer to the center
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                // i +1 --> left pointer move to right
                // j - 1 --> right pointer move to left
                return (isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1));
            }
        }
        return true;
    }
    // ---solution finished

    // check if a char sequence is palindrome
    public boolean isPalindrome(CharSequence s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII sol = new ValidPalindromeII();
        assert sol.validPalindrome("aba") == true : "T1 failed";
        assert sol.validPalindrome("abca") == true : "T2 failed";
    }
}
